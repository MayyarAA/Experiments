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
const CaptchaImage = require('../Model/CaptchaImage.js');
const uuid = require('uuid');
const { getDateTime } = require('../Services/Utils.js');
const RootMutationType = new GraphQLObjectType({
	name: 'RootMutation',
	description: 'root mutation obj',
	fields: () => ({
		addCaptchaImage: {
			type: CaptchaImageTypeQL,
			description: 'fcn to add captchaimage',
			args: {
				// imageData: { type: CaptchaImageTypeQL },
				Id: { type: GraphQLString },
				ImageValue: { type: GraphQLString },
				ImageData: { type: GraphQLString },
			},
			resolve: (parent, args) => {
				console.log(
					' Id => ' + args.Id + ' ImageValue=> ' + args.ImageValue + ' @ ' + getDateTime()
				);
				const newImage = {
					Id: uuid.v4(),
					ImageValue: args.ImageValue,
					ImageData: args.ImageData,
				};
				addImageToDB(newImage);
				return newImage;
			},
		},
		userSelectedImages: {
			type: new GraphQLList(CaptchaImageTypeQL),
			description: 'list of user selected images',
			args: {
				dataInput: { type: GraphQLString },
			},
			resolve: (parent, args) => {
				console.log(`from userSelectedImages => ${args.dataInput} @ ${getDateTime()}`);
				return args.dataInput;
			},
		},
	}),
});
const addImageToDB = async (image) => {
	const ImageValue = image.ImageValue;
	const ImageData = image.ImageData;
	const Id = image.Id;
	console.log(JSON.stringify(image));
	const newImage = CaptchaImage({ Id, ImageValue, ImageData });
	try {
		await newImage.save();
	} catch (e) {
		throw new Error('error unable to save image => ' + e);
	}
};
module.exports = RootMutationType;
