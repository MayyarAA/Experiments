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

const captchaImages = [
	{ Id: 1, data: 'datastring' },
	{ Id: 2, data: 'datastring2' },
];

module.exports = { CaptchaImageTypeQL, captchaImages };
