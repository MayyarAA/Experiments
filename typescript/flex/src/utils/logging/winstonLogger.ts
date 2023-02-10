// const winston = require('winston');
import winston, { format } from 'winston';
const MESSAGE = Symbol.for('message');
const myFormat = winston.format.printf(({ level, message, timestamp }: any) => {
	return JSON.stringify({ timestamp, level, message });
});

const jsonFormatter = (logEntry) => {
	const base = { timestamp: new Date() };
	const json = Object.assign(base, logEntry);
	logEntry[MESSAGE] = JSON.stringify(json);
	return logEntry;
};

const loggerOptions: winston.LoggerOptions = {
	level: 'info',
	format: winston.format.combine(
		winston.format.timestamp({
			format: 'YYYY-MM-DD HH:mm:ss',
		}),
		winston.format(jsonFormatter)(),
		winston.format.json()
	),
	defaultMeta: { service: 'user-service' },
	transports: [
		// new winston.transport.File()
		new winston.transports.File({
			filename: 'error.log',
			level: 'error',
			format: winston.format.combine(
				winston.format.timestamp(),
				// winston.format.colorize(),
				myFormat
			),
		}),
		new winston.transports.File({
			filename: 'combined.log',
			format: winston.format.combine(
				winston.format.timestamp(),
				// winston.format.colorize(),
				myFormat
			),
		}),
		new winston.transports.Console({
			level: 'debug',
			format: winston.format.combine(
				winston.format.timestamp(),
				// winston.format.colorize(),
				myFormat
			),
		}),
	],
};

const logger = winston.createLogger(loggerOptions);
logger.info('lslslsl');
logger.error('Sasas');
if (process.env.NODE_ENV !== 'production') {
	logger.add(
		new winston.transports.Console({
			format: winston.format.simple(),
		})
	);
}

export { logger };
