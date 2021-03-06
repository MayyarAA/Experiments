const {
	GraphQLSchema,
	GraphQLObjectType,
	GraphQLString,
	GraphQLList,
	GraphQLInt,
	GraphQLNonNull,
	GraphQLID,
	GraphQLInputObjectType,
	graphqlSync,
} = require('graphql');

const { CaptchaImageTypeQL } = require('../GraphQLTypes/ImageQLType');
const { ValidationService } = require('../Services/ValidationService.js');
const CaptchaImage = require('../Model/CaptchaImage.js');
const uuid = require('uuid');
const { getDateTime } = require('../Services/Utils.js');
const RootMutationType = new GraphQLObjectType({
	name: 'RootMutation',
	description: 'root mutation obj',
	fields: () => ({
		addCaptchaImage: {
			type: CaptchaImageTypeQL, //This is the return type of the request
			description: 'fcn to add captchaimage',
			args: {
				Id: { type: GraphQLString }, //This is the input type for dynamic requests
				ImageValue: { type: GraphQLString },
				ImageData: { type: GraphQLString },
			},
			resolve: (parent, args) => {
				// console.log(
				// 	' Id => ' + args.Id + ' ImageValue=> ' + args.ImageValue + ' @ ' + getDateTime()
				// );
				// console.log(args);
				const newImage = {
					Id: uuid.v4(),
					ImageValue: args.ImageValue,
					ImageData: args.ImageData,
				};
				addImageToDB(newImage);
				return newImage;
			},
		},
		addCaptchaImageUsingInputType: {
			type: CaptchaImageTypeQL, //This is the return type of the request
			description: 'fcn to add addCaptchaImageUsingInputType',
			args: {
				// prettier-ignore
				input: { type: CaptchaImageMutationInput }, //This is a unqiue input type for mutations
			},
			resolve: (parent, args) => {
				const newImage = {
					Id: uuid.v4(),
					ImageValue: args.input.ImageValue,
					ImageData: args.input.ImageData,
				};
				addImageToDB(newImage);
				return newImage;
			},
		},
		userSelectedImages: {
			type: new GraphQLList(CaptchaImageTypeQL),
			// type: GraphQLString,
			description: 'list of user selected images',
			args: {
				dataInput: { type: new GraphQLList(CaptchaImageMutationInput) },
			},
			resolve: (parent, args) => {
				let graphQLRespone = [];
				try {
					// console.log('args.dataInput => ' + JSON.stringify(args.dataInput));
					const result = ValidationService(args.dataInput, getDateTime());
					if (!result) throw new Error('Error invalid selection');
					graphQLRespone = buildUserSelectedImagesResponse(result);
					console.log('sucess valid selection');
				} catch (e) {
					console.log('error invalid selection');
					return e;
				}
				console.log('result val => ' + JSON.stringify(graphQLRespone));
				return graphQLRespone;
			},
		},
	}),
});

const buildUserSelectedImagesResponse = (data) => {
	console.log(JSON.stringify(data));
	let res = [{ ImageData: 'Correct', ImageValue: 'Correct', Id: 'Correct' }];
	return res;
};

// const CaptchaImageListInputType

//specila input type for mutation
const CaptchaImageMutationInput = new GraphQLInputObjectType({
	name: 'CaptchaImageMutationInput',
	description: 'Input payload for creating new image',
	fields: () => ({
		ImageData: {
			type: GraphQLString,
		},
		ImageValue: {
			type: GraphQLString,
		},
		Id: {
			type: GraphQLString,
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
