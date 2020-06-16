package com.codenation.desafio.mappers;

import org.mapstruct.Mapper;

import com.codenation.desafio.dto.UserUpdateDTO;
import com.codenation.desafio.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User map(UserUpdateDTO userDTO);

}
