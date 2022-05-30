import { useMutation, gql } from '@apollo/client';

const PostUserSelectedImagesAPICall = () => {
	console.log('PostUserSelectedImagesAPICall');
	const postImagesQuery = gql(`
  mutation userSelectedImages{
    userSelectedImages(dataInput:[{Id:"1111",
          ImageValue:"imageValue",
          ImageData:"dataImage" },{
          Id:"11222",
          ImageValue:"imageValue222",
          ImageData:"dataImage222"
      }]){
      Id
    }
    
  }`);
	const [userSelectedImagesMutation, { loading, error, data }] = useMutation(postImagesQuery);
	// useEffect(() => {
	userSelectedImagesMutation();
	console.log('userSelectedImagesMutation');
	// }, []);

	if (loading) {
		console.log(loading);
		while (loading) {
			console.log(' in loading while loop');
		}
	}
	// return 'Data is loading';
	if (error) {
		console.log(error);
		return 'Error during request';
	}
	console.log(data);
	return data;
};

export { PostUserSelectedImagesAPICall };
