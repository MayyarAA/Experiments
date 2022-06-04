import MainGrid from '../Components/MainGrid.js';
import { SubmitButton } from '../Components/SubmitButton.js';
import { HeaderComponent } from '../Components/Header.js';
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

						<Grid item justify='right'>
							<SubmitButton />
						</Grid>
					</Grid>
				</Grid>
			</div>
		</div>
	);
}

export { CaptchaMainPage };
