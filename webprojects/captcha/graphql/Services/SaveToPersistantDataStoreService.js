const fs = require('fs');
const { getDateTime } = require('./Utils.js');
let correctImagesfile = require('./correctImages.json');
const SaveToPersistantDataStoreService = (images) => {
	//open file first and clear it
	correctImagesfile = [];
	console.log('before ' + JSON.stringify(correctImagesfile));
	images.forEach((image) => {
		correctImagesfile.push(image);
	});
	console.log(JSON.stringify(correctImagesfile));
	const dataPassedToFile = JSON.stringify(correctImagesfile);
	//need to define the path relative to the home directory of the node proj
	//relative from where server.js is
	fs.writeFile('./services/correctImages.json', dataPassedToFile, 'utf8', (err) => {
		console.log('writeFile');
		if (err) {
			console.log('Error during writing to file ' + getDateTime() + ' ' + err);
			throw err;
		}
		console.log('Done writing to file ' + getDateTime()); // Success
	});
};
module.exports = { SaveToPersistantDataStoreService };
