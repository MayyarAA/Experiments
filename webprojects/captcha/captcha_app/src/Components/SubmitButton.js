import { useContext } from 'react';
import Button from '@mui/material/Button';
import { useMutation, gql } from '@apollo/client';
import ValidationService from '../Services/ValidationService.js';
import { ValidationAPICall } from '../APICalls/ValidationAPICall.js';
import { DataContext } from '../Context/Context.js';
import GetImageService from '../Services/GetImageService.js';
import { PostUserSelectedImagesService } from '../Services/PostUserSelectedImagesService.js';
import { PostUserSelectedImagesAPICall } from '../APICalls/PostUserSelectedImagesAPICall.js';

const postImagesQuery = gql(`
  mutation userSelectedImages{
    userSelectedImages(dataInput:[{Id:"6544444",
          ImageValue:"6544444imageValue",
          ImageData:"dataImage" },{
          Id:"6544444",
          ImageValue:"6544444imageValue222",
          ImageData:"dataImage222"
      }]){
      Id
    }
    
  }`);

function SubmitButton(props) {
	const { selectedImages } = useContext(DataContext);
	const [userSelectedImagesMutation, { loading, error, data }] = useMutation(postImagesQuery);
	const submitButtonEventHandler = (event) => {
		// PostUserSelectedImagesService();
		event.preventDefault();
		// const { userSelectedImagesMutation } = PostUserSelectedImagesAPICall();
		userSelectedImagesMutation();
		// PostUserSelectedImagesAPICall();
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
