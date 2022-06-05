const {
	GraphQLSchema,
	GraphQLObjectType,
	GraphQLString,
	GraphQLList,
	GraphQLInt,
	GraphQLNonNull,
	GraphQLID,
} = require('graphql');

const CaptchaImageTypeQL = new GraphQLObjectType({
	name: 'CaptchaImage',
	description: 'Image used for captcha',
	fields: () => ({
		Id: { type: GraphQLString },
		ImageValue: { type: GraphQLString },
		ImageData: { type: GraphQLString },
	}),
});

module.exports = { CaptchaImageTypeQL };
