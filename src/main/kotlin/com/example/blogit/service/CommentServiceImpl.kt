package com.example.blogit.service

import com.example.blogit.DTO.CommentDTO
import com.example.blogit.DTO.PostDTO
import com.example.blogit.repository.CommentRepo
import com.example.blogit.utills.mapper.CommentMapper
import org.springframework.stereotype.Service

@Service
class CommentServiceImpl(
        val commentMapper : CommentMapper,
        val commentRepo : CommentRepo
) : CommentService
{
    override fun createComment(commentDTO: CommentDTO): CommentDTO
    {
        if(commentDTO.id!=-1)
        {
            throw Exception("Invalid Id")
        }
        return commentMapper.fromEntity(commentRepo.save(commentMapper.toEntity(commentDTO)))

    }

    override fun getComment(): List<CommentDTO>
    {

        val commentIterable = commentRepo.findAll();
        val comments = mutableListOf<CommentDTO>()
        commentIterable.forEach{
            comments.add(commentMapper.fromEntity(it))
        }
        return comments
    }

    override fun deleteComment(id: Int)
    {
         commentRepo.deleteById(id)
    }

    override fun updateComment(commentDto: CommentDTO): CommentDTO
    {
        val comment =commentMapper.toEntity(commentDto)
        commentRepo.save(comment)
        return commentMapper.fromEntity(comment)
    }

    override fun getCommentById(id: Int): CommentDTO
    {
        return commentMapper.fromEntity(commentRepo.findById(id).get())
    }

    override fun getCommentByPostId(id: Int): List<CommentDTO>
    {
        val commentIterable = commentRepo.findByPostId(id);
        val comments = mutableListOf<CommentDTO>()
        commentIterable.forEach{
            comments.add(commentMapper.fromEntity(it))
        }
        return comments

    }


}