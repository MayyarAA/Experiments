const express = require('express');
const app = express();
const { authors, books } = require('./fakeData.js');

const { graphqlHTTP } = require('express-graphql');
const {
	GraphQLSchema,
	GraphQLObjectType,
	GraphQLString,
	GraphQLList,
	GraphQLInt,
	GraphQLNonNull,
	GraphQLID,
} = require('graphql');

const AuthorTyopeQL = new GraphQLObjectType({
	name: 'AuthorObj',
	description: 'Author of book',
	fields: () => ({
		id: { type: GraphQLNonNull(GraphQLID) },
		name: { type: GraphQLNonNull(GraphQLString) },
	}),
});
const BookTypeQL = new GraphQLObjectType({
	name: 'Book',
	description: 'Book object',
	fields: () => ({
		id: { type: GraphQLNonNull(GraphQLID) },
		name: { type: GraphQLNonNull(GraphQLString) },
		authorId: { type: GraphQLNonNull(GraphQLInt) },
		author: {
			type: AuthorTyopeQL,
			resolve: (book) => {
				return authors.find(author.id == book.authorId);
			},
		},
	}),
});

const RootQuery = new GraphQLObjectType({
	name: 'RootQuery',
	description: 'Root Query',
	fields: () => ({
		message: {
			type: GraphQLString,
			resolve: () => 'First GraphQLSchemaObj',
		},
		books: {
			type: new GraphQLList(BookTypeQL),
			description: 'List of all books',
			resolve: () => books,
		},
	}),
});

const schemaComplex = new GraphQLSchema({
	query: RootQuery,
});

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
