import express from 'express';
import { mainRouter } from './routes/mainRoute';
import { logger } from './utils/logging/winstonLogger';
const app = express();
const port = 3000;
// const mainRouter =
logger.info('Testing**********');
app.get('/', (req, res) => {
	res.send('Hello World!');
});

app.use('/main', mainRouter);
app.listen(port, () => {
	return console.log(`Express is listening at http://localhost:${port}`);
});
