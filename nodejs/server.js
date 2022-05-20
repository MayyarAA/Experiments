import express from 'express';
import { SecondFileMainRunner } from './secondFile.js';
import { ThirdFileMainRunner } from './thirdFile.js';
const app = express();
const PORT = 5001;

app.listen(PORT, () => {
	console.log(`app listening on port ${PORT}`);
});
const mainFcnRunner = () => {
	firFcn();
	secFcn();
};

const secFcn = () => {
	console.log('logging from sec fcn');
	// firFcn();
};

const thriFcn = (str, time, timeFcn) => {
	console.log('logging from thriFcn before setTimeout ***');
	return new Promise((resolve, reject) => {
		setTimeout(() => {
			console.log('logging from inside setTimeout');
			resolve();
			timeFcn(str, time);
		}, time * 2);
	});
};

const firFcn = async () => {
	console.log('*logging from fir Fcn before thriFcn call');
	await thriFcn('logging from thir fnc', 2, (str, time) => {
		console.log(`${str} + ${time} in the timeFcn`);
	});
	console.log('*logging from fir Fcn after thriFcn call');
};

// mainFcnRunner();
//SecondFileMainRunner();
ThirdFileMainRunner();
