import React, { createContext, useState } from 'react';

const DataContext = createContext();

const DataContextProvider = (props) => {
	const [selectedImages, setSelectedImages] = useState({});
	const [currentListOfAllImages, setCurrentListOfAllImages] = useState([]);
	return (
		<DataContext.Provider
			value={{
				selectedImages,
				setSelectedImages,
				currentListOfAllImages,
				setCurrentListOfAllImages,
			}}>
			{props.children}
		</DataContext.Provider>
	);
};

export { DataContext, DataContextProvider };
