import logo from './logo.svg';
import './App.css';
import { CaptchaMainPage } from './Pages/CaptchaMainPage.js';
import { DataContextProvider } from './Context/Context.js';

function App() {
	return (
		<DataContextProvider>
			<div className='App'>
				<CaptchaMainPage />
			</div>
		</DataContextProvider>
	);
}

export default App;
