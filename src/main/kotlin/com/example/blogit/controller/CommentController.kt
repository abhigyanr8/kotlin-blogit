package com.example.blogit.controller

import com.example.blogit.DTO.CommentDTO
import com.example.blogit.DTO.PostDTO
import com.example.blogit.service.CommentService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CommentController
(
        val commentService:CommentService
)
{
    @PostMapping("comment")
    fun createComment(@RequestBody commentDTO:CommentDTO):CommentDTO
    {
        return commentService.createComment(commentDTO)
    }

    @PutMapping("comment")
    fun updateComment(@RequestBody commentDTO:CommentDTO):CommentDTO
    {
        return commentService.updateComment(commentDTO)
    }
    @DeleteMapping("comment/{id}")
    fun deleteComment(@PathVariable id:Int)
    {
        commentService.deleteComment(id)
    }
    @GetMapping("comment/{id}")
    fun getCommentById(@PathVariable id:Int):CommentDTO
    {
         return commentService.getCommentById(id)
    }

    @GetMapping("comments/post/{id}")
    fun getCommentByPostId(@PathVariable id:Int):List<CommentDTO>
    {
       return commentService.getCommentByPostId(id)
    }

}