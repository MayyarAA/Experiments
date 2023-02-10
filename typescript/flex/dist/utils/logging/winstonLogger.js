"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.logger = void 0;
// const winston = require('winston');
const winston_1 = __importDefault(require("winston"));
const MESSAGE = Symbol.for('message');
const myFormat = winston_1.default.format.printf(({ level, message, timestamp }) => {
    // return `${timestamp} [${label}] ${level}: ${message}`;
    console.log('level' + typeof level + level);
    // return JSON.stringify({ timestamp, level: JSON.stringify(level), message });
    return JSON.stringify({ timestamp, level, message });
});
const jsonFormatter = (logEntry) => {
    const base = { timestamp: new Date() };
    const json = Object.assign(base, logEntry);
    logEntry[MESSAGE] = JSON.stringify(json);
    return logEntry;
};
const loggerOptions = {
    level: 'info',
    format: winston_1.default.format.combine(winston_1.default.format.timestamp({
        format: 'YYYY-MM-DD HH:mm:ss',
    }), winston_1.default.format(jsonFormatter)(), winston_1.default.format.json()),
    defaultMeta: { service: 'user-service' },
    transports: [
        // new winston.transport.File()
        new winston_1.default.transports.File({
            filename: 'error.log',
            level: 'error',
            format: winston_1.default.format.combine(winston_1.default.format.timestamp(), 
            // winston.format.colorize(),
            myFormat),
        }),
        new winston_1.default.transports.File({
            filename: 'combined.log',
            format: winston_1.default.format.combine(winston_1.default.format.timestamp(), 
            // winston.format.colorize(),
            myFormat),
        }),
        new winston_1.default.transports.Console({
            level: 'debug',
            format: winston_1.default.format.combine(winston_1.default.format.timestamp(), 
            // winston.format.colorize(),
            myFormat),
        }),
    ],
};
const logger = winston_1.default.createLogger(loggerOptions);
exports.logger = logger;
logger.info('lslslsl');
logger.error('Sasas');
if (process.env.NODE_ENV !== 'production') {
    logger.add(new winston_1.default.transports.Console({
        format: winston_1.default.format.simple(),
    }));
}
//# sourceMappingURL=winstonLogger.js.map