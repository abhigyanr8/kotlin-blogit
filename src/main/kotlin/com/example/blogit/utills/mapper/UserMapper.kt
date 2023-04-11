package com.example.blogit.utills.mapper

import com.example.blogit.DTO.UserDTO
import com.example.blogit.Model.User
import org.springframework.stereotype.Service

@Service
class UserMapper : Mapper<UserDTO,User>
{
    override fun fromEntity(entity: User): UserDTO=UserDTO(
              entity.id,
              entity.name,
              entity.email,
              entity.password,
              entity.about
    )


    override fun toEntity(domain: UserDTO): User = User(
            domain.id,
            domain.name,
            domain.email,
            domain.password,
            domain.about
    )


}