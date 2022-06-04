const fs = require('fs');
const { getDateTime } = require('./Utils.js');
const correctImages = require('./correctImages.json');
const ReadFromPersistantDataStore = () => {
	return correctImages;
};

module.exports = { ReadFromPersistantDataStore };
