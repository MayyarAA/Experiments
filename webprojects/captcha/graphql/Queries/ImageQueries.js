const {
	GraphQLSchema,
	GraphQLObjectType,
	GraphQLString,
	GraphQLList,
	GraphQLInt,
	GraphQLNonNull,
	GraphQLID,
} = require('graphql');

const { CaptchaImageTypeQL, captchaImages } = require('../GraphQLTypes/ImageQLType');
const { getDateTime } = require('../Services/Utils.js');
const { getImagesService } = require('../Services/GetImageDBService.js');
const RootQuery = new GraphQLObjectType({
	name: 'RootQuery',
	description: 'Root Query',
	fields: () => ({
		message: {
			type: GraphQLString,
			resolve: () => 'First GraphQLSchemaObj',
		},
		captchaImage: {
			type: CaptchaImageTypeQL,
			args: { Id: { type: GraphQLInt } },
			resolve: (parent, args) => {
				const images = getImagesService();
				const image = images[0];
				// addToDB(res);
				// CaptchaImage.save()
				return image;
			},
		},
		getImages: {
			type: new GraphQLList(CaptchaImageTypeQL),
			description: 'list of all images',
			args: { random: { type: GraphQLString } },
			resolve: (parent, args) => {
				const images = getImagesService();
				if (images !== null && images !== undefined) {
					// console.log(`from getImages p2=> ${JSON.stringify(images[0])} @ ${getDateTime()}`);
				}
				return images;
			},
		},
	}),
});

module.exports = RootQuery;
