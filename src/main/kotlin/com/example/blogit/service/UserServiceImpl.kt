package com.example.blogit.service

import com.example.blogit.DTO.UserDTO
import com.example.blogit.Model.User
import com.example.blogit.repository.UserRepo
import com.example.blogit.utills.mapper.UserMapper
import org.springframework.stereotype.Service
import kotlin.IllegalArgumentException

@Service
class UserServiceImpl
        (
             private val userRepo:UserRepo,
             private val userMapper: UserMapper
        ) : UserService
{


    override fun createUser(userDto: UserDTO) : UserDTO
    {
              if(userDto.id!=-1)
              {
                  throw Exception("Invalid Id")
              }
              val user =userMapper.toEntity(userDto)
              userRepo.save(user)
              return userMapper.fromEntity(user)


    }
    override fun getUsers():List<UserDTO>
    {
        val userIterable = userRepo.findAll();
        val users = mutableListOf<UserDTO>()
        userIterable.forEach{
              users.add(userMapper.fromEntity(it))
        }
        return users
    }

    override fun deleteUser(id: Int)
    {
         val user =userRepo.findById(id)
         userRepo.deleteById(id)

    }
    override fun updateUser(userDto: UserDTO) : UserDTO
    {
        val user =userMapper.toEntity(userDto)
        userRepo.save(user)
        return userMapper.fromEntity(user)
    }
    override fun getUserById(id:Int) :UserDTO
    {
             return userMapper.fromEntity(userRepo.findById(id).get())
    }
}