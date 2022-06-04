import { useContext } from 'react';
import Button from '@mui/material/Button';
import { useMutation, gql } from '@apollo/client';
import ValidationService from '../Services/ValidationService.js';
import { ValidationAPICall } from '../APICalls/ValidationAPICall.js';
import { DataContext } from '../Context/Context.js';
import GetImageService from '../Services/GetImageService.js';
import { PostUserSelectedImagesService } from '../Services/PostUserSelectedImagesService.js';
import { PostUserSelectedImagesAPICall } from '../APICalls/PostUserSelectedImagesAPICall.js';

function SubmitButton(props) {
	const userSelection = [];
	const postImagesQuery = gql(`mutation userSelectedImages($data:[CaptchaImageMutationInput]){
		userSelectedImages(dataInput:$data){
		  Id
		}
		
	  }`);
	const { selectedImages } = useContext(DataContext);
	const [userSelectedImagesMutation, { loading, error, data }] = useMutation(postImagesQuery);
	const submitButtonEventHandler = (event) => {
		// PostUserSelectedImagesService();
		event.preventDefault();
		// const { userSelectedImagesMutation } = PostUserSelectedImagesAPICall();
		userSelectedImagesMutation({ variables: { data: selectedImages } });
		// PostUserSelectedImagesAPICall();
		console.log('clickde button');
		console.log('selectedImages => ' + selectedImages + ' ' + JSON.stringify(selectedImages));
		// ValidationAPICall();
		// ValidationService();
	};
	let button = (
		<div>
			<Button
				style={{ float: 'right' }}
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

// [{Id:"6544444",
//           ImageValue:"6544444imageValue",
//           ImageData:"dataImage" },{
//           Id:"6544444",
//           ImageValue:"6544444imageValue222",
//           ImageData:"dataImage222"
//       }]
