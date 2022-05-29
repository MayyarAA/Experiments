const cors = require('cors');
const express = require('express');
const app = express();
const connectDB = require('./config/database.js');
const { authors, books } = require('./fakeData.js');
const CaptchaImage = require('./Model/CaptchaImage.js');
const RootQuery = require('./Queries/ImageQueries.js');
const RootMutationType = require('./Mutations/ImageMutations.js');
// console.log(JSON.stringify(RootQuery));
const { graphqlHTTP } = require('express-graphql');
const uuid = require('uuid');
const {
	GraphQLSchema,
	GraphQLObjectType,
	GraphQLString,
	GraphQLList,
	GraphQLInt,
	GraphQLNonNull,
	GraphQLID,
} = require('graphql');

//queries
connectDB();

//mutations

const addImageToDB = async (image) => {
	const data = image.data;
	const Id = image.Id;
	console.log(JSON.stringify(image));
	const newImage = CaptchaImage({ data, Id });
	try {
		await newImage.save();
	} catch (e) {
		throw new Error('error unable to save image => ' + e);
	}
};

const schemaComplex = new GraphQLSchema({
	query: RootQuery,
	mutation: RootMutationType,
	// mutation: null,
});

app.use(
	cors({
		origin: 'http://localhost:3000', // allow to server to accept request from different origin
		// origin: `${process.env.CLIENTSIDE_PORT}`, // allow to server to accept request from different origin
		methods: 'GET,HEAD,PUT,PATCH,POST,DELETE',
		credentials: true, // allow session cookie from browser to pass through
	})
);
app.use(
	'/graphql',
	graphqlHTTP({
		schema: schemaComplex,
		graphiql: true,
	})
);
app.listen(5000, () => console.log('App listing'));

// // declaring new graphQLschema
// const schemaSimple = new GraphQLSchema({
// 	//declaring new graphQLobj
// 	query: new GraphQLObjectType({
// 		name: 'FirstGraphQLObjs',
// 		fields: () => ({
// 			message: {
// 				type: GraphQLString,
// 				resolve: () => 'First GraphQLSchemaObj',
// 			},
// 		}),
// 	}),
// });
