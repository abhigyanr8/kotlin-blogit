package com.example.blogit.controller

import com.example.blogit.DTO.UserDTO
import com.example.blogit.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class UserController(
        private val userService: UserService
)
{
    @PostMapping("user")
    fun createMovie(@RequestBody userDTO:UserDTO) : ResponseEntity<UserDTO>
    {
        try{
          return ResponseEntity(userService.createUser(userDTO),HttpStatus.CREATED)
           }
        catch (exception:IllegalArgumentException)
        {
            return ResponseEntity(null,HttpStatus.BAD_REQUEST);

        }
    }
    @GetMapping("users")
    fun getMapping():List<UserDTO>
    {
        return userService.getUsers();
    }
    @GetMapping("user/{id}")
    fun getUserById(@PathVariable id:Int):UserDTO
    {
        return userService.getUserById(id)
    }
    @DeleteMapping("user/{id}")
    fun deleteUser(@PathVariable id:Int)
    {
        userService.deleteUser(id)
    }
    @PutMapping("users")
    fun updateUser(@RequestBody userDTO:UserDTO) :UserDTO
    {
            return userService.updateUser(userDTO)
    }
}