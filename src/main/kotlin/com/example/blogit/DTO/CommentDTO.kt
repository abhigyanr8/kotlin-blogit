package com.example.blogit.DTO


import jakarta.persistence.Id


data class CommentDTO
(

        var id :Int=-1,
        var comment : String,
        var userId:Int,
        var postId:Int
)
