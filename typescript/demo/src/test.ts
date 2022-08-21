// const a = 'hello';
// console.log('this is the console ' + a);

let tes: number = 20;
const helperFcn1 = (data1: string, data2: number): string => {
	return data1 + ' ' + data2;
};

interface IUser {
	name: string;
	id: number;
	getMessage(): string;
}

const user1: IUser = {
	name: 'Tom',
	id: 10,
	getMessage() {
		return 'hello from ' + this.name;
	},
};

let pageNumber: string | number = 10;

pageNumber = '15';

// let value1: number;

// console.log(value1, value1);
const customLog = (nameOfValue, value) => {
	console.log(`${nameOfValue} ${typeof value} w/ value ${value}`);
	console.log('---------------------------------------------------');
};

type CustomNumberAlias = number | null;
let value2: CustomNumberAlias = 10;
customLog(Object.keys({ value2 })[0], value2);

value2 = null;
customLog(Object.keys({ value2 })[0], value2);
