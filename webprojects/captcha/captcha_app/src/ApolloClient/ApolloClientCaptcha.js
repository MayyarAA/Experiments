import { ApolloClient, InMemoryCache } from '@apollo/client';

const ApolloClientCaptcha = new ApolloClient({
	// uri: 'https://48p1r2roz4.sse.codesandbox.io',
	uri: 'http://localhost:5000/graphql',
	cache: new InMemoryCache(),
});

export { ApolloClientCaptcha };
