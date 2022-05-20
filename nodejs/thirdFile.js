const ThirdFileMainRunner = async () => {
	console.log('ThirdFileMainRunner');
	let userName;
	userName = await GetUserName(); //the main thread will wait for GetUserName() bec it is returning a Promise
	// if (userName != null || userName != undefined) {
	MakeUserNameCaps(userName);
	console.log('ThirdFileMainRunner after MakeUserNameCaps');
	// }
};

const GetUserName = () => {
	let userName;
	return new Promise((resolve, reject) => {
		try {
			setTimeout(() => {
				userName = 'Tom';
				if (userName != undefined || userName != null) {
					console.log('in GetUserName>setTimeout userName is set to ' + userName);
					resolve(userName);
				}
				reject('Error');
			}, 3 * 1000);
		} catch (error) {
			console.log('error in setimeout');
		}
	});
};

const MakeUserNameCaps = (userName) => {
	console.log('MakeUserNameCaps log => ' + userName.toUpperCase());
};
export { ThirdFileMainRunner };
