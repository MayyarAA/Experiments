import { useContext } from 'react';
import Button from '@mui/material/Button';
import { useMutation, gql } from '@apollo/client';
import { DataContext } from '../Context/Context.js';

function SubmitButton(props) {
	const userSelection = [];
	const { selectedImages } = useContext(DataContext);

	const submitButtonEventHandler = (event) => {
		console.log('clickde button');
		console.log('selectedImages => ' + selectedImages + ' ' + JSON.stringify(selectedImages));
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
