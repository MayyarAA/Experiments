import { useQuery, gql } from '@apollo/client';
const GetAllImagesAPICall = () => {
	const getImagesQuery = gql(`
    query getAllImages {
        getImages(random:"1555555"){
          Id
          ImageData
          ImageValue
        }
      }`);
	const { loading, error, data } = useQuery(getImagesQuery);
	if (loading) return 'Data is loading';
	if (error) {
		console.log(error);
		return 'Error during request';
	}
	console.log(data);
	return data;
};

export { GetAllImagesAPICall };
