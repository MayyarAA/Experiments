import { useQuery, gql } from '@apollo/client';
function GetImageCall() {
	const getImageQuery = gql(`
    query CaptchaImage{
		captchaImage(Id:1){
		  Id
		  ImageData
		  ImageValue
		}
	  }`);

	const { loading, error, data } = useQuery(getImageQuery);
	if (loading) return 'Data is loading';
	if (error) {
		console.log(error);
		return 'Error during request';
	}
	console.log(data);
	return data;
}

export { GetImageCall };
