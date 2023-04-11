package com.example.blogit.repository

import com.example.blogit.Model.Post
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepo :CrudRepository<Post,Int>
{

}