package com.example.blogit.Model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Comment
(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id:Int=-1,
        var comment:String,
        var userId:Int,
        var postId:Int
)
