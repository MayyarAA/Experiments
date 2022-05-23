import Button from '@mui/material/Button';
import ValidationService from '../Services/ValidationService.js';
function SubmitButton(props) {
	const submitButtonEventHandler = (event) => {
		console.log('clickde button');
		ValidationService();
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
