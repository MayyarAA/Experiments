const Products = require('../models/products');

const getProductsController = async() => {
  console.log(" in getProductsController")
  return Products.findAll()
}

const postProductsController = async (productModel) => {
  console.log("Starting product creation: " + JSON.stringify(productModel))  
  const createdProducet = await Products.create({
    name: productModel.name,
    price: productModel.price,
    mrp: productModel.mrp,
    stock: productModel.stock,
    isPublished: productModel.isPublished,
  })

  return createdProducet
}


const patchProductsController = async (productId) => {
  console.log("Starting patch: " + productId)
  let product = await Products.findByPk(productId);
  const responseStatus = {}
  if(Products.stock < 0 && product.mrp <= product.price){
    responseStatus.isValidRequest = false;
    responseStatus.body = ["MRP should be less than equal to the Price", "Stock count is 0"]
  } else if(Products.stock < 0){
    responseStatus.isValidRequest = false;
    responseStatus.body = ["Stock count is 0"]
  } else if(product.mrp <= product.price){
    responseStatus.isValidRequest = false;
    responseStatus.body = ["MRP should be less than equal to the Price"]
  }else{
    const updatedProduct = await Products.update({isPublished: true},{where: {id:productId}})
    responseStatus.isValidRequest = true;
  }

  return responseStatus

}

const productsController = {getProductsController, postProductsController, patchProductsController}
module.exports = productsController;