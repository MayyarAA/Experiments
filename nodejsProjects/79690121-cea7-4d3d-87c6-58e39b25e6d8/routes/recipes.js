var recipes = require('../recipes.json');
var router = require('express').Router();
const recipesGetIdsService = require('../controller/recipesService.js');
router.route('/shopping-list').get(async (req, res) => {
	const ids = req.query.ids;
	console.log('here!!!!!!!' + ids);

	if (ids === undefined || ids === null || typeof ids === 'undefined') {
		console.log('error');
		res.status(400).end();
		return;
	}

	const idsArr = ids.split(',');
	const resData = recipesGetIdsService(idsArr);
	console.log('resData : ' + resData);

	if (resData === undefined || resData === null || resData.length === 0) {
		res.status(404).send('NOT_FOUND');
		return;
	}
  console.log("resData" + JSON.stringify(resData))
	res.status(200).json(resData);
	return;
});
module.exports = router;
