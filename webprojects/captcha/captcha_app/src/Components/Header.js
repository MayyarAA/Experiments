import { Typography } from '@mui/material';
const getDateTime = (type) => {
	let text = '';
	if (type === 'simple') {
		text = new Date().toLocaleString();
	} else {
		text = 'LastSync: ' + new Date().toLocaleString();
	}
	return text;
};
export const HeaderComponent = () => {
	let text = `Captcha Clone`;
	let text2 = getDateTime('simple');
	let component = (
		<div>
			<Typography variant='h2' style={{ flexGrow: 1, textAlign: 'center' }}>
				{text}
			</Typography>
			<Typography variant='h5' style={{ flexGrow: 1, textAlign: 'center' }}>
				{text2}
			</Typography>
		</div>
	);
	return <div>{component}</div>;
};
