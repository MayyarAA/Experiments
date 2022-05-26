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

//queries

const AuthorTyopeQL = new GraphQLObjectType({
	name: 'AuthorObj',
	description: 'Author of book',
	fields: () => ({
		id: { type: GraphQLNonNull(GraphQLID) },
		name: { type: GraphQLNonNull(GraphQLString) },
	}),
});

const CaptchaImageTypeQL = new GraphQLObjectType({
	name: 'CaptchaImage',
	description: 'Image used for captcha',
	fields: () => ({
		id: { type: GraphQLNonNull(GraphQLID) },
		data: { type: GraphQLNonNull(GraphQLString) },
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
				return authors.find((author) => author.id == book.authorId);
			},
		},
	}),
});
const captchaImages = [
	{ id: 1, data: 'datastring' },
	{ id: 2, data: 'datastring2' },
];

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
			args: { id: { type: GraphQLInt } },
			resolve: (parent, args) => {
				return captchaImages.find((image) => image.id == args.Id);
			},
		},
		book: {
			type: BookTypeQL,
			description: 'One singel book by bookId',
			args: { bookId: { type: GraphQLInt } },
			resolve: (parent, args) => {
				return books.find((book) => book.id == args.bookId);
			},
		},
		books: {
			type: new GraphQLList(BookTypeQL),
			description: 'List of all books',
			resolve: () => books,
		},
		authors: {
			type: new GraphQLList(AuthorTyopeQL),
			resolve: () => authors,
		},
	}),
});

//mutations

const RootMutationType = new GraphQLObjectType({
	name: 'RootMutation',
	description: 'root mutation obj',
	fields: () => ({
		addBook: {
			type: BookTypeQL,
			description: 'fcn to add book',
			args: {
				name: { type: GraphQLNonNull(GraphQLString) },
				authorId: { type: GraphQLNonNull(GraphQLInt) },
			},
			resolve: (parent, args) => {
				const newBook = { id: books.length + 1, name: args.name, authorId: args.authorId };
				books.push(newBook); //bec we not using db rn, simple example
				return newBook; //just to return successful book created
			},
		},
	}),
});

const schemaComplex = new GraphQLSchema({
	query: RootQuery,
	mutation: RootMutationType,
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
