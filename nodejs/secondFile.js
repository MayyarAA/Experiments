function createCustomTimeout(seconds) {
	return new Promise((resolve, reject) => {
		setTimeout(() => {
			console.log('bla bla');
			resolve();
		}, seconds * 1000);
	});
}

async function testing() {
	console.log('testing function has been triggered');
	await createCustomTimeout(4);
	console.log('bla');
}

const secFcn = () => {
	console.log('secFcn log');
};
const SecondFileMainRunner = () => {
	testing();
	secFcn();
};
export { SecondFileMainRunner };
