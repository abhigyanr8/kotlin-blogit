package com.example.blogit.utills.mapper

import com.example.blogit.DTO.CommentDTO
import com.example.blogit.DTO.PostDTO
import com.example.blogit.Model.Comment
import com.example.blogit.Model.Post
import org.springframework.stereotype.Service


@Service
class CommentMapper : Mapper<CommentDTO,Comment>
{
    override fun fromEntity(entity: Comment): CommentDTO = CommentDTO(
            entity.id,
            entity.comment,
            entity.userId,
            entity.postId
    )


    override fun toEntity(domain:CommentDTO):Comment =Comment(
            domain.id,
            domain.comment,
            domain.userId,
            domain.postId

    )

}