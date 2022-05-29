import { useQuery, gql } from '@apollo/client';
import { useContext } from 'react';
import { DataContext } from '../Context/Context.js';
const GetAllImagesAPICall = () => {
	const { setCurrentListOfAllImages } = useContext(DataContext);
	console.log('GetAllImagesAPICall ');
	const getImagesQuery = gql(`
    query getAllImages {
        getImages(random:"11111"){
          Id
          ImageData
          ImageValue
        }
      }`);
	const { loading, error, data } = useQuery(getImagesQuery);
	if (loading) {
		console.log('loading => ' + loading);
		// 	// while (loading) {}
		return;
	}
	if (error) {
		console.log(error);
		return 'Error during request';
	}
	setCurrentListOfAllImages(data.getImages);
	console.log(data.getImages);
	// return data;
};

export { GetAllImagesAPICall };
