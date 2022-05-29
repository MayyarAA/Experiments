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
				res = captchaImages.find((image) => image.Id == args.Id);
				console.log(JSON.stringify(res));
				// addToDB(res);
				// CaptchaImage.save()
				return res;
			},
		},
		getImages: {
			type: new GraphQLList(CaptchaImageTypeQL),
			description: 'list of all images',
			args: { random: { type: GraphQLString } },
			resolve: (parent, args) => {
				const images = getImageDBsService();
				console.log('from getImages');
				return images;
			},
		},
	}),
});

const getImageDBsService = () => {
	let imageArr = FakeImages;
	let imageArrV2 = [];
	for (let i = 0; i < imageArr.length; i++) {
		// image=imageArr[i]
		// image.Id = i+1
		// imageArr[i] = imageArr[i].Id + 1;
		imageArrV2.push({ Id: i + 1, ImageValue: imageArr[i].img, ImageData: imageArr[i].title });
	}
	console.log(imageArrV2);
	return imageArrV2;
};

module.exports = RootQuery;
