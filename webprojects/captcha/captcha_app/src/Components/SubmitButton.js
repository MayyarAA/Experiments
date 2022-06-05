import { useContext, useEffect } from 'react';
import Button from '@mui/material/Button';
import { useMutation, gql } from '@apollo/client';
import ValidationService from '../Services/ValidationService.js';
import { ValidationAPICall } from '../APICalls/ValidationAPICall.js';
import { DataContext } from '../Context/Context.js';
import GetImageService from '../Services/GetImageService.js';
import { PostUserSelectedImagesService } from '../Services/PostUserSelectedImagesService.js';
import { PostUserSelectedImagesAPICall } from '../APICalls/PostUserSelectedImagesAPICall.js';

let responseFromSubmitValidation;
function SubmitButton(props) {
	const userSelection = [];
	const postImagesQuery = gql(`mutation userSelectedImages($data:[CaptchaImageMutationInput]){
		userSelectedImages(dataInput:$data){
		  Id
		}
		
	  }`);
	const { selectedImages, setStatusOfValidation } = useContext(DataContext);
	// const [userSelectedImagesMutation, { loading, error, data, success }] = useMutation(
	// 	postImagesQuery
	// );
	const [userSelectedImagesMutation, { loading, error, data, success }] = useMutation(
		postImagesQuery
	);
	const submitButtonEventHandler = (event) => {
		event.preventDefault();
		userSelectedImagesMutation({ variables: { data: selectedImages } });

		// console.log('clickde button');
		// console.log('selectedImages => ' + selectedImages + ' ' + JSON.stringify(selectedImages));
	};
	if (error) {
		responseFromSubmitValidation = 'Error';
		setStatusOfValidation('Error');
		console.log('rr');
	} else if (data) {
		responseFromSubmitValidation = 'Success';
		setStatusOfValidation('Success');
		console.log('ss');
	}
	let button = (
		<div>
			{/* {error ? <div>An error occurred: {error.message}</div> : null}
			{data ? <div>Todo added!</div> : null} */}
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

export { SubmitButton, responseFromSubmitValidation };

// [{Id:"6544444",
//           ImageValue:"6544444imageValue",
//           ImageData:"dataImage" },{
//           Id:"6544444",
//           ImageValue:"6544444imageValue222",
//           ImageData:"dataImage222"
//       }]
