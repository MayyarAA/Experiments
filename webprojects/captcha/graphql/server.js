const cors = require('cors');
const express = require('express');
const app = express();
const connectDB = require('./config/database.js');
const RootQuery = require('./Queries/ImageQueries.js');
const RootMutationType = require('./Mutations/ImageMutations.js');
const { graphqlHTTP } = require('express-graphql');
const { getDateTime } = require('./Services/Utils.js');
const uuid = require('uuid');
const { GraphQLSchema } = require('graphql');

connectDB();

const schemaComplex = new GraphQLSchema({
	//queries
	query: RootQuery,
	//mutations
	mutation: RootMutationType,
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
app.listen(5000, () => console.log('App listing ' + getDateTime()));
