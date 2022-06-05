import { useEffect, useContext } from 'react';
import MainGrid from '../Components/MainGrid.js';
import { SubmitButton, responseFromSubmitValidation } from '../Components/SubmitButton.js';
import { DataContext } from '../Context/Context.js';
import { CancelButton } from '../Components/CancelButton.js';
import { RefreshButton } from '../Components/RefreshButton.js';
import { HeaderComponent } from '../Components/Header.js';
import { GetAllImagesService } from '../Services/GetAllImagesService.js';
import { Grid, Box, Typography } from '@mui/material';

function CaptchaMainPage() {
	let component;
	const { statusOfValidation } = useContext(DataContext);
	if (statusOfValidation === 'Pending') {
		component = (
			<div style={{ display: 'flex', justifyContent: 'center' }}>
				<Grid container spacing={3} alignItems='center' justify='center'>
					<Grid item>
						<div style={{ justifyContent: 'center' }}>
							<HeaderComponent />
						</div>
						<Box justify='center'></Box>
						<Box>
							<MainGrid />
						</Box>

						<Box
							component='span'
							m={1}
							display='flex'
							justifyContent='space-between'
							alignItems='center'>
							<CancelButton />
							<RefreshButton />
							<SubmitButton />
						</Box>

						<Grid item justify='right'></Grid>
					</Grid>
				</Grid>
			</div>
		);
	} else if (statusOfValidation === 'Error') {
		component = (
			<div>
				<Typography variant='h5' style={{ flexGrow: 1, textAlign: 'center' }}>
					Error Try Again
				</Typography>
				<RefreshButton />
			</div>
		);
	} else if (statusOfValidation === 'Success') {
		component = <div>Success</div>;
	}

	useEffect(() => {}, [statusOfValidation]);

	return <div>{component}</div>;
}

export { CaptchaMainPage };
