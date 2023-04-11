package com.example.blogit.utills.mapper

import com.example.blogit.DTO.PostDTO
import com.example.blogit.Model.Post
import org.springframework.stereotype.Service

@Service
class PostMapper : Mapper<PostDTO,Post>
{
    override fun fromEntity(entity: Post): PostDTO = PostDTO(
            entity.id,
            entity.title,
            entity.content,
            entity.userId
    )


    override fun toEntity(domain:PostDTO):Post = Post(
            domain.id,
            domain.title,
            domain.content,
            domain.userId

    )
}