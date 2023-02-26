const Posts = require('../models/posts');

const postsController = {}
const createPost = async(post) => {
  console.log("Start of post: " + post)
  if(post.isPublished){
    post.publishedDate = Date.now(); // getTime()
  }else{
    post.isPublished = false;
  }

  const createdPost = Posts.create({
    title: post.title,
     author: post.author,
      timestamp: post.timestamp,
       isPublished : post.isPublished
  })

  return createdPost
}

const getAllPosts = async (author, isPublished) => {
  const conditionalRequirnment = {}
  if(author !== null){
    conditionalRequirnment.author = author
  }

  
}


postsController.createPost = createPost;
postsController.getAllPosts = getAllPosts
module.exports = postsController;