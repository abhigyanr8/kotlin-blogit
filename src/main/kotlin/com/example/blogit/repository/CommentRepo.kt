package com.example.blogit.repository

import com.example.blogit.Model.Comment
import org.springframework.data.repository.CrudRepository

interface CommentRepo  : CrudRepository<Comment,Int>
{
    fun findByPostId(postId:Int): List<Comment>
}