import useContext from 'react';
import axios from 'axios';
import { DataContext } from '../Context/Context.js';

const ValidationAPICall = () => {
	const { setUserData } = useContext(DataContext);
	const validationAPICallHelper = async () => {
		let url = `http://localhost:5000/graphql`;
		await axios({
			method: 'post',
			url,
		})
			.then(function (response) {
				setUserData(response.data[0]);
				console.log(response.data);
			})
			.catch(function (error) {
				console.log(error);
			});
	};
};
export { ValidationAPICall };
