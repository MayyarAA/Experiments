import { useContext } from 'react';
import Button from '@mui/material/Button';
import ValidationService from '../Services/ValidationService.js';
import { ValidationAPICall } from '../APICalls/ValidationAPICall.js';
import { DataContext } from '../Context/Context.js';
import GetImageService from '../Services/GetImageService.js';
import { PostUserSelectedImagesService } from '../Services/PostUserSelectedImagesService.js';
function SubmitButton(props) {
	const { selectedImages } = useContext(DataContext);
	const submitButtonEventHandler = (event) => {
		PostUserSelectedImagesService();
		console.log('clickde button');
		console.log('selectedImages => ' + selectedImages + ' ' + JSON.stringify(selectedImages));
		// ValidationAPICall();
		// ValidationService();
	};
	let button = (
		<div>
			<Button
				variant='outlined'
				onClick={(event) => {
					submitButtonEventHandler(event);
				}}>
				Submit
			</Button>
		</div>
	);

	return <div>{button}</div>;
}

export { SubmitButton };
