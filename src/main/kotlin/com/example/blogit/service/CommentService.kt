package com.example.blogit.service

import com.example.blogit.DTO.CommentDTO
import com.example.blogit.DTO.PostDTO

interface CommentService
{
    fun createComment(commentDto: CommentDTO):CommentDTO
    fun getComment():List<CommentDTO>
    fun deleteComment(id:Int)
    fun updateComment(commentDto: CommentDTO): CommentDTO
    fun getCommentById(id:Int):CommentDTO

    fun getCommentByPostId(id:Int):List<CommentDTO>
}