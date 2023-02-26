const router = require('express').Router();
const productsController = require('../controllers/products');
// const productsController = re

const getProducts = async (req, res)=>{
  const data = await productsController.getProductsController();
  res.status(200).send(data)
}

const postProductsController = async(req, res) => {
  const { name, price, mrp, stock } = req.body;
  const newProduct = {name, price, mrp, stock, isPublished: false };

  try{

    const response = await productsController.postProductsController(newProduct)    
    // console.log(response)
    res.status(201).json(response);
  } catch (error) {
    res.status(409).json({ message: error.message });
  }

}

const patchProductsRoute = async (req, res) => {  
  try{
    const id = req.params.id;   
    const responseStatus = await productsController.patchProductsController(req.params.id);
    if(responseStatus.isValidRequest == true){
      res.status(204);
    } else{
      res.status(422).json(responseStatus.body);
    }
    return;
  } catch (error) {
    res.status(409).json({ message: error.message });
  }

}

router.get('/', getProducts)
router.post('/', postProductsController)
router.patch('/:id', patchProductsRoute)
router.route('/:id').delete(async (req, res) => {
  const id = req.params.id;
  console.log("Starting or delete")   
  res.status(405);
  return;
});
router.route('/:id').put(async (req, res) => {
  const id = req.params.id;   
  console.log("Starting or put")   
  res.status(405);
  return;
});

module.exports = router;
