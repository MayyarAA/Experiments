import React, { createContext, useState } from 'react';

const DataContext = createContext();

const DataContextProvider = (props) => {
	const [selectedImages, setSelectedImages] = useState({});
	return (
		<DataContext.Provider value={{ selectedImages, setSelectedImages }}>
			{props.children}
		</DataContext.Provider>
	);
};

export { DataContext, DataContextProvider };
