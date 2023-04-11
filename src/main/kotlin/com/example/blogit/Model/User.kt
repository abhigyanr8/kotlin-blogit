package com.example.blogit.Model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class User
(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id :Int,
        var name :String,
        var email :String,
        var password:String,
        var about : String
)
