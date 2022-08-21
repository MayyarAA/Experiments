// const a = 'hello';
// console.log('this is the console ' + a);
var tes = 20;
var helperFcn1 = function (data1, data2) {
    return data1 + ' ' + data2;
};
var user1 = {
    name: 'Tom',
    id: 10,
    getMessage: function () {
        return 'hello from ' + this.name;
    }
};
var pageNumber = 10;
pageNumber = '15';
// let value1: number;
// console.log(value1, value1);
var customLog = function (nameOfValue, value) {
    console.log("".concat(nameOfValue, " ").concat(typeof value, " w/ value ").concat(value));
    console.log('---------------------------------------------------');
};
var value2 = 10;
customLog(Object.keys({ value2: value2 })[0], value2);
value2 = null;
customLog(Object.keys({ value2: value2 })[0], value2);
