package com.sinhro.spring1.service;

import com.sinhro.spring1.dto.UsersDto;
import com.sinhro.spring1.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UsersConverter {
    public Users fromUserDtoToUser(UsersDto usersDto){
        Users users = new Users();
        users.setName(usersDto.getName());
        users.setEmail(usersDto.getEmail());
        users.setId(usersDto.getId());
        users.setLogin(usersDto.getLogin());
        return users;
    }

    public UsersDto fromUserToUserDTO(Users users){
        return UsersDto.builder()
                .id(users.getId())
                .email(users.getEmail())
                .name(users.getName())
                .login(users.getLogin())
                .build();
    }
}
