var recipes = require('../recipes.json');
/**
 *
 * given list of ids
 * return aggregated ingrediants across all ids
 */
const recipesGetIdsService = (ids) => {
	console.log('ids in service : ' + ids);
	const allIngrediants = [];
	for (let i = 0; i < ids.length; i++) {
		const id = ids[i];
		if (id <= 0 || id > ids.length) {
			continue;
		}
		const recipe = recipes[id - 1];
    if (recipe === undefined || recipe === null) {
			continue;
		}
		console.log('recipe for id : ' + id + recipe);
		allIngrediants.push(...recipe.ingredients);
	}  
	return [...allIngrediants];
};
module.exports = recipesGetIdsService;
