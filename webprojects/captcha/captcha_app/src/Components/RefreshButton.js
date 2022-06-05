import Button from '@mui/material/Button';

const RefreshButton = () => {
	const refreshButtonEventHandler = (event) => {
		window.location.reload(false);
	};
	let button = (
		<div>
			<Button
				style={{ float: 'right' }}
				variant='outlined'
				onClick={(event) => {
					refreshButtonEventHandler(event);
				}}>
				Refresh
			</Button>
		</div>
	);

	return <div>{button}</div>;
};

export { RefreshButton };
