const {
	GraphQLSchema,
	GraphQLObjectType,
	GraphQLString,
	GraphQLList,
	GraphQLInt,
	GraphQLNonNull,
	GraphQLID,
} = require('graphql');

const {
	CaptchaImageTypeQL,

	captchaImages,
} = require('../GraphQLTypes/ImageQLType');
const { getDateTime } = require('../Services/Utils.js');
const { FakeImages } = require('../fakeData.js');
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
				// console.log('req made here => captchaImage');
				// res = captchaImages.find((image) => image.Id == args.Id);
				const images = getImageDBsService();
				const image = images[0];
				// console.log(JSON.stringify(images));
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
				const images = getImageDBsService();
				if (images !== null && images !== undefined) {
					// console.log(`from getImages p2=> ${JSON.stringify(images[0])} @ ${getDateTime()}`);
				}
				return images;
			},
		},
	}),
});

const getImageDBsService = () => {
	let imageArr = FakeImages;
	let imageArrV2 = [];
	for (let i = 0; i < 9; i++) {
		imageArrV2.push({ Id: i + 1, ImageValue: imageArr[i].img, ImageData: imageArr[i].title });
	}
	return imageArrV2;
};

module.exports = RootQuery;
