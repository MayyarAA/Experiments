import useContext from 'react';
import { DataContext } from '../Context/Context.js';
export default function ValidationService() {
	const correctImages = { id: 1, id: 2 };
	const { selectedImages } = useContext(DataContext);

	//check if any of the images in correctImages is not con
	//check if any of the images in selectedImages are not in correctImages
	if (Object.keys(correctImages).length != selectedImages) return false;
	//api call for validation
	return true;
}
