import { GetAllImagesAPICall } from '../APICalls/GetAllImagesAPICall';
const GetAllImagesService = () => {
	const listOfImages = GetAllImagesAPICall();
	console.log(listOfImages);
};

export { GetAllImagesService };
