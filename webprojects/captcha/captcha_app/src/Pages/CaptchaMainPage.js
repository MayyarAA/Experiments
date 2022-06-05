import { useEffect, useContext } from 'react';
import MainGrid from '../Components/MainGrid.js';
import { SubmitButton } from '../Components/SubmitButton.js';
import { CancelButton } from '../Components/CancelButton.js';
import { RefreshButton } from '../Components/RefreshButton.js';
import { HeaderComponent } from '../Components/Header.js';
import { GetAllImagesService } from '../Services/GetAllImagesService.js';
import { Grid, Box } from '@mui/material';

function CaptchaMainPage() {
	return (
		<div>
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
		</div>
	);
}

export { CaptchaMainPage };
