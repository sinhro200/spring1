package com.sinhro.spring1.service;

import com.sinhro.spring1.dto.UsersDto;
import com.sinhro.spring1.exception.ValidationException;

import java.util.List;

public interface UsersService {
    UsersDto saveUser(UsersDto usersDto) throws ValidationException;

    void deleteUser(Integer userId);

    UsersDto findByLogin(String login);

    List<UsersDto> findAll();
}
