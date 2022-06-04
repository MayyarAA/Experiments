const _ = require('lodash');
const { FakeImages } = require('../fakeData.js');
const { SaveToPersistantDataStoreService } = require('./SaveToPersistantDataStoreService.js');

const getImagesService = () => {
	let imageArr = getRandomValues(FakeImages, 9);
	SaveToPersistantDataStoreService(imageArr);
	let imageArrV2 = [];
	for (let i = 0; i < 9; i++) {}
	return imageArr;
};

const getRandomValues = (orgList, size) => {
	let randomList = _.sampleSize(orgList, size);
	return randomList;
};

module.exports = { getImagesService };
