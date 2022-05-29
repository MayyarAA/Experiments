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

const RootMutationType = new GraphQLObjectType({
	name: 'RootMutation',
	description: 'root mutation obj',
	fields: () => ({
		addCaptchaImage: {
			type: CaptchaImageTypeQL,
			description: 'fcn to add captchaimage',
			args: {
				data: { type: GraphQLNonNull(GraphQLString) },
				// Id: { type: GraphQLNonNull(GraphQLInt) },
			},
			resolve: (parent, args) => {
				const newImage = { Id: uuid.v4(), data: args.data };
				addImageToDB(newImage);
				return newImage;
			},
		},
	}),
});

module.exports = RootMutationType;
