import React, { createContext, useState } from 'react';
import { GetAllImagesService } from '../Services/GetAllImagesService.js';
const DataContext = createContext();

const DataContextProvider = (props) => {
	const [selectedImages, setSelectedImages] = useState([]);
	const [currentListOfAllImages, setCurrentListOfAllImages] = useState([]);
	const getAllImagesContextService = () => {
		setCurrentListOfAllImages(GetAllImagesService());
	};

	return (
		<DataContext.Provider
			value={{
				selectedImages,
				setSelectedImages,
				currentListOfAllImages,
				setCurrentListOfAllImages,
				getAllImagesContextService,
			}}>
			{props.children}
		</DataContext.Provider>
	);
};

export { DataContext, DataContextProvider };
