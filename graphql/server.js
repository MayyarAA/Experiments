const express = require('express');
const app = express();
const { graphqlHTTP } = require('express-graphql');
const {
	GraphQLSchema,
	GraphQLObjectType,
	GraphQLString,
	GraphQLList,
	GraphQLInt,
	GraphQLNonNull,
} = require('graphql');

//declaring new graphQLschema
const schema = new GraphQLSchema({
	//declaring new graphQLobj
	query: new GraphQLObjectType({
		name: 'FirstGraphQLObjs',
		fields: () => ({
			message: {
				type: GraphQLString,
				resolve: () => {
					'First GraphQLSchemaObj';
				},
			},
		}),
	}),
});

app.use(
	'/graphql',
	graphqlHTTP({
		schema: schema,
		graphiql: true,
	})
);
app.listen(5000, () => console.log('App listing'));
