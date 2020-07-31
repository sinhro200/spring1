package com.sinhro.spring1.service;

import com.sinhro.spring1.dto.UsersDto;
import com.sinhro.spring1.entity.Users;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class UsersConverter {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsersConverter(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Users fromUserDtoToUser(UsersDto usersDto){
        Users users = new Users();
        users.setName(usersDto.getName());
        users.setEmail(usersDto.getEmail());
        users.setId(usersDto.getId());
        users.setLogin(usersDto.getLogin());
        users.setPassword(bCryptPasswordEncoder.encode(usersDto.getPassword()));
        users.setRoles(usersDto.getRoles());
        return users;
    }

    public UsersDto fromUserToUserDTO(Users users){
        return UsersDto.builder()
                .id(users.getId())
                .email(users.getEmail())
                .name(users.getName())
                .login(users.getLogin())
                .password(users.getPassword())
                .roles(users.getRoles())
                .build();
    }
}
