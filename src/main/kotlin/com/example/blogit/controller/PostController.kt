package com.example.blogit.controller

import com.example.blogit.DTO.PostDTO
import com.example.blogit.DTO.UserDTO
import com.example.blogit.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class PostController(
        val postService: PostService
)
{
    @PostMapping("post")
    fun createPost(@RequestBody postDTO: PostDTO) : ResponseEntity<PostDTO>
    {
        try{
            return ResponseEntity(postService.createPost(postDTO), HttpStatus.CREATED)
        }
        catch (exception:IllegalArgumentException)
        {
            return ResponseEntity(null, HttpStatus.BAD_REQUEST);

        }
    }
    @GetMapping("posts")
    fun getPosts():List<PostDTO>
    {
        return postService.getPost()
    }
    @DeleteMapping("post/{id}")
    fun deletePost(@PathVariable id:Int)
    {
        postService.deletePost(id)
    }
    @PutMapping("post")
    fun updatePost(@RequestBody postDto:PostDTO):PostDTO
    {
        return postService.updatePost(postDto)
    }
    @GetMapping("post/{id}")
    fun getPostById(@PathVariable id:Int):PostDTO
    {
        return postService.getPostById(id)
    }



}