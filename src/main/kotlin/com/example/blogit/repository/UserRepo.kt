package com.example.blogit.repository

import com.example.blogit.Model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.RepositoryDefinition
import org.springframework.stereotype.Repository

@Repository
interface UserRepo :CrudRepository<User,Int> {
}