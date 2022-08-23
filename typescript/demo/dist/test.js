// const a = 'hello';
// console.log('this is the console ' + a);
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var tes = 20;
var helperFcn1 = function (data1, data2) {
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
var customLog = function (nameOfValue, value) {
    console.log("".concat(JSON.stringify(nameOfValue), " typeof ").concat(typeof value, " w/ value ").concat(JSON.stringify(value)));
    console.log('---------------------------------------------------');
};
var value2 = 10;
// customLog(Object.keys({ value2 })[0], value2);
value2 = null;
var popularTags = ['good', 'happy'];
var helperFcn2 = function (data) {
    //do some work
    console.log('here in void fcn');
};
var page = '10';
var pageNumber = page;
var UserClass = /** @class */ (function () {
    function UserClass(firstName, id) {
        this.firstName = firstName;
        this.id = id;
    }
    UserClass.prototype.getFirstName = function () {
        return this.firstName;
    };
    UserClass.prototype.getMessage = function () {
        return 'hello message';
    };
    return UserClass;
}());
var AdminUserClass = /** @class */ (function (_super) {
    __extends(AdminUserClass, _super);
    function AdminUserClass(firstName, id, adminSecretKey) {
        var _this = _super.call(this, firstName, id) || this;
        _this.adminSecretKey = adminSecretKey;
        return _this;
    }
    return AdminUserClass;
}(UserClass));
var adminUser1 = new AdminUserClass('TomeUser1', 10, 'secretKEy10202102010');
customLog(Object.keys({ user2: adminUser1 })[0], adminUser1);
