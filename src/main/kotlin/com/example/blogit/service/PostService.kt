package com.example.blogit.service

import com.example.blogit.DTO.PostDTO

interface PostService
{
    fun createPost(postDto: PostDTO): PostDTO
    fun getPost():List<PostDTO>
    fun deletePost(id:Int)
    fun updatePost(postDto: PostDTO): PostDTO
    fun getPostById(id:Int): PostDTO
}