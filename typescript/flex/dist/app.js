"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = __importDefault(require("express"));
const mainRoute_1 = require("./routes/mainRoute");
const winstonLogger_1 = require("./utils/logging/winstonLogger");
const app = (0, express_1.default)();
const port = 3000;
// const mainRouter =
winstonLogger_1.logger.info('Testing**********');
app.get('/', (req, res) => {
    res.send('Hello World!');
});
app.use('/main', mainRoute_1.mainRouter);
app.listen(port, () => {
    return console.log(`Express is listening at http://localhost:${port}`);
});
//# sourceMappingURL=app.js.map