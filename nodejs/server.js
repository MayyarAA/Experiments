import express from 'express';

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
	setTimeout(() => {
		//call back fcn
		timeFcn(str, time);
	}, time);
	console.log('this log is inside the thriFcn but is compiled right under setTimeout');
};

const firFcn = async () => {
	console.log('*logging from fir Fcn before thriFcn call');
	thriFcn('logging from thir fnc', 2, (str, time) => {
		console.log(`${str} + ${time}`);
	});
	console.log('*logging from fir Fcn after thriFcn call');
};

mainFcnRunner();
