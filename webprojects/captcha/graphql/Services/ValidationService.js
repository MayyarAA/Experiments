const ValidationService = (args, orgList, reqTime) => {
	// console.log(JSON.stringify(args));
	const correctSelectionMap = buildMap(orgList);
	// const userSelectionMap = buildMap(orgList);
	for (image in args) {
		if (!correctSelectionMap.includes(image.Id)) return false;
	}
	console.log('validation service');
	return true;
};
const buildMap = (list) => {
	let imagesMap = [];
	for (let i = 0; i < list.length; i++) {
		console.log(list[i]);
		// imagesMap[list[i].Id] = list[i].Id;
		imagesMap.push(list[i].Id);
	}
	console.log(imagesMap);
	return imagesMap;
};

module.exports = { ValidationService };
