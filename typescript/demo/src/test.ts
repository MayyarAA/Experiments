// const a = 'hello';
// console.log('this is the console ' + a);
import * as R from 'ramda';
let tes: number = 20;
const helperFcn1 = (data1: string, data2: number): string => {
	return data1 + ' ' + data2;
};

// interface IUser {
// 	name: string;
// 	id: number;
// 	getMessage(): string;
// }

// const user1: IUser = {
// 	name: 'Tom',
// 	id: 10,
// 	getMessage() {
// 		return 'hello from ' + this.name;
// 	},
// };

// let pageNumber: string | number = 10;

// pageNumber = '15';

// let value1: number;

// console.log(value1, value1);
const customLog = (nameOfValue, value) => {
	console.log(
		`${JSON.stringify(nameOfValue)} typeof ${typeof value} w/ value ${JSON.stringify(value)}`
	);
	console.log('---------------------------------------------------');
};

type CustomNumberAlias = number | null;
let value2: CustomNumberAlias = 10;
// customLog(Object.keys({ value2 })[0], value2);

value2 = null;
// customLog(Object.keys({ value2 })[0], value2);

type PopularTag = string;

const popularTags: PopularTag[] = ['good', 'happy'];

const helperFcn2 = (data): void => {
	//do some work
	console.log('here in void fcn');
};

let page: string = '10';
let pageNumber: number = (page as unknown) as number;
// customLog(pageNumber, pageNumber);
// console.log('pageNumber', pageNumber);

//classes

interface IUser {
	name: string;
	id: number;
	getMessage(): string;
}

class UserClass implements IUser {
	private firstName: string;
	name: string;
	id: number;
	constructor(firstName: string, id: number) {
		this.firstName = firstName;
		this.id = id;
	}
	getFirstName(): string {
		return this.firstName;
	}
	getMessage() {
		return 'hello message';
	}
}

class AdminUserClass extends UserClass {
	private adminSecretKey: string;
	constructor(firstName: string, id: number, adminSecretKey: string) {
		super(firstName, id);
		this.adminSecretKey = adminSecretKey;
	}
}

const adminUser1 = new AdminUserClass('TomeUser1', 10, 'secretKEy10202102010');
customLog(Object.keys({ user2: adminUser1 })[0], adminUser1);

///reading custom code

const searchStr = 'hello';
const arrTest = ['hello', 'type', 'test'];
// const updatedNumArray = R.any<string>((el: string) => el.contains(searchStr), arrTest);
