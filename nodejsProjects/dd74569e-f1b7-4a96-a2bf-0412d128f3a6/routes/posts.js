const express = require('express');
const router = express.Router();
const postsController = require('../controllers/posts');

const postRouter = async (req, res) => {
  const {title, author, timestamp, isPublished} = req.body
  const post = {title, author, timestamp, isPublished}
  try{
    const createdPost = await postsController.createPost(post);
    res.status(201).json(createdPost)
  }catch(e){
    res.status(400).send();
  }
}

const getRouter = async(req, res) => {
  const author = req.query.author
  let  isPublished = null;
  if(req.query.isPublished == 'true'){
    isPublished = true
  } else if( req.query.isPublished == 'false'){
    isPublished = false
  }
  
  try{
    const allPosts = await postsController.getAllPosts(author, isPublished)
    res.status(200).json(allPosts)
  }catch(e){
    res.status(400).send();
  }
}


const getByIdRouter = async(req, res) => {
  try{

  }catch(e){
    res.status(400).send();
  }
}

router.post('/', postRouter)
router.get('/', getRouter)
router.get('/:id', getByIdRouter)
module.exports = router;
