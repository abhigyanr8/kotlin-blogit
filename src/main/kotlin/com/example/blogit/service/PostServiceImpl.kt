package com.example.blogit.service

import com.example.blogit.DTO.PostDTO
import com.example.blogit.DTO.UserDTO
import com.example.blogit.repository.PostRepo
import com.example.blogit.utills.mapper.PostMapper
import org.springframework.stereotype.Service

@Service
class PostServiceImpl
(

      val postMapper:PostMapper,
      val postRepo :PostRepo

):PostService
{
    override fun createPost(postDto: PostDTO): PostDTO
    {
        if(postDto.id!=-1)
        {
            throw Exception("Invalid Id")
        }
        return postMapper.fromEntity(postRepo.save(postMapper.toEntity(postDto)))
    }

    override fun getPost(): List<PostDTO>
    {

        val postIterable = postRepo.findAll();
        val posts = mutableListOf<PostDTO>()
        postIterable.forEach{
            posts.add(postMapper.fromEntity(it))
        }
        return posts
    }

    override fun deletePost(id: Int)
    {

        val post =postRepo.findById(id)
        postRepo.deleteById(id)
    }

    override fun updatePost(postDto: PostDTO): PostDTO
    {

        val post =postMapper.toEntity(postDto)
        postRepo.save(post)
        return postMapper.fromEntity(post)
    }

    override fun getPostById(id: Int): PostDTO
    {

        return postMapper.fromEntity(postRepo.findById(id).get())
    }

}