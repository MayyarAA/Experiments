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
	}),
});

module.exports = RootQuery;
