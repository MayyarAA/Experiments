import logo from './logo.svg';
import './App.css';
import { CaptchaMainPage } from './Pages/CaptchaMainPage.js';
import { DataContextProvider } from './Context/Context.js';
import { ApolloClientCaptcha } from './ApolloClient/ApolloClientCaptcha.js';
import { ApolloProvider } from '@apollo/client';
function App() {
	console.log('App ');
	return (
		<DataContextProvider>
			<ApolloProvider client={ApolloClientCaptcha}>
				<div className='App'>
					{/* <ExchangeRates /> */}
					<CaptchaMainPage />
				</div>
			</ApolloProvider>
		</DataContextProvider>
	);
}

export default App;
