const { ReadFromPersistantDataStore } = require('./ReadFromPersistantDataStore.js');
const ValidationService = (userSelectedImages, reqTime) => {
	const correctSelectionMap = buildMap(ReadFromPersistantDataStore());
	for (let i = 0; i < userSelectedImages.length; i++) {
		const image = userSelectedImages[i];
		// console.log('user sel imag' + JSON.stringify(image));
		if (!correctSelectionMap.includes(image.Id)) {
			console.log('user sel imag id ' + typeof image.Id);
			return false;
		}
	}
	console.log('validation service');
	return true;
};
const buildMap = (list) => {
	let imagesMap = [];
	for (let i = 0; i < list.length; i++) {
		// console.log(list[i]);
		// imagesMap[list[i].Id] = list[i].Id;
		imagesMap.push(list[i].Id.toString());
	}
	console.log(imagesMap);
	return imagesMap;
};

module.exports = { ValidationService };
