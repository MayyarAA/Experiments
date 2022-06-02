import { useState, useEffect, useContext } from 'react';
import ImageList from '@mui/material/ImageList';
import ImageListItem from '@mui/material/ImageListItem';
import { DataContext } from '../Context/Context.js';
import { GetAllImagesService } from '../Services/GetAllImagesService.js';
export default function MainGrid() {
	console.log('Here from MainGrid');
	GetAllImagesService();
	return (
		<div>
			Here from MainGrid
			<StandardImageList />
		</div>
	);
}
const imageObj = {
	Id: 11111,
	title: 'big image',
};

function ImageObjectAPIVersion(Id, imageTitle) {
	this.Id = Id;
	this.imageTitle = imageTitle;
}
function StandardImageList(props) {
	const { selectedImages, setSelectedImages, currentListOfAllImages } = useContext(
		DataContext
	);
	const [localImageList, setLocalImageList] = useState([]);

	// if (currentListOfAllImages === null || currentListOfAllImages === undefined) {
	// 	GetAllImagesService();
	// }
	useEffect(() => {
		console.log(currentListOfAllImages);
	}, [currentListOfAllImages]);

	const indexOfObject = (arr, Id) => {
		arr.findIndex((object) => {
			return object.id === Id;
		});
	};
	let imageIdsMap = {};
	const imageListClickHandler = (image) => {
		console.log('before edit => ' + JSON.stringify(selectedImages));
		if (image.Id in imageIdsMap) {
			//image already in unselect it

			let selectedImagesLocal = selectedImages;
			selectedImagesLocal.splice(imageIdsMap[image.Id], 1);
			setSelectedImages(selectedImagesLocal);
			// console.log('here now ' + image.Id);
		} else {
			imageIdsMap[image.Id] = selectedImages.length;
			//add image to selected
			let selectedImagesLocal = selectedImages;
			selectedImagesLocal.push({
				Id: image.Id,
				ImageValue: image.ImageValue,
				ImageData: image.ImageData,
			});
			setSelectedImages(selectedImagesLocal);
		}
		console.log('after edit => ' + JSON.stringify(selectedImages));
	};
	if (currentListOfAllImages !== null && currentListOfAllImages !== undefined) {
		console.log(currentListOfAllImages);
		return (
			<ImageList sx={{ width: 500, height: 450 }} cols={3} rowHeight={164}>
				{currentListOfAllImages.map((item, i) => (
					<ImageListItem
						key={item.img}
						onClick={() => {
							// console.log(props.itemData[i]);
							// console.log(item);
							imageListClickHandler(item);
						}}>
						<img
							src={`${item.ImageValue}?w=164&h=164&fit=crop&auto=format`}
							srcSet={`${item.ImageValue}?w=164&h=164&fit=crop&auto=format&dpr=2 2x`}
							alt={item.ImageData}
							loading='lazy'
						/>
					</ImageListItem>
				))}
			</ImageList>
		);
	} else {
		return <div> Buffering </div>;
	}
}
