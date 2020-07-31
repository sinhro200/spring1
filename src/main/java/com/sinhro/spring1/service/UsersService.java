package com.sinhro.spring1.service;

import com.sinhro.spring1.dto.UsersDto;
import com.sinhro.spring1.exception.ValidationException;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsersService extends UserDetailsService {
    boolean saveUser(UsersDto usersDto) throws ValidationException;

    void deleteUser(Integer userId);

    UsersDto findByLogin(String login);

    List<UsersDto> findAll();
}
