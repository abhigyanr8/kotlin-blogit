package com.example.blogit.service

import com.example.blogit.DTO.UserDTO


interface UserService
{
    fun createUser(userDto: UserDTO): UserDTO
    fun getUsers():List<UserDTO>
    fun deleteUser(id:Int)
    fun updateUser(userDto:UserDTO):UserDTO
    fun getUserById(id:Int):UserDTO
}