import { GetImageCall } from '../APICalls/GetImageCall.js';

const GetImageService = () => {
	const res = GetImageCall();
	console.log(res);
};

export default GetImageService;
