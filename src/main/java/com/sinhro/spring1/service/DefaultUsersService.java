package com.sinhro.spring1.service;

import com.sinhro.spring1.dto.UsersDto;
import com.sinhro.spring1.entity.Users;
import com.sinhro.spring1.exception.ValidationException;
import com.sinhro.spring1.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class DefaultUsersService implements UsersService{

    private final UsersRepository usersRepository;
    private final UsersConverter usersConverter;


    public DefaultUsersService(UsersRepository usersRepository, UsersConverter usersConverter) {
        this.usersRepository = usersRepository;
        this.usersConverter = usersConverter;
    }

    @Override
    public UsersDto saveUser(UsersDto usersDto) throws ValidationException {
        validateUserDto(usersDto);
        Users savedUser = usersRepository.save(usersConverter.fromUserDtoToUser(usersDto));
        return usersConverter.fromUserToUserDTO(savedUser);
    }

    @Override
    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public UsersDto findByLogin(String login) {
        Users users = usersRepository.findByLogin(login);
        if (users!= null){
            return usersConverter.fromUserToUserDTO(users);
        }
        return null;
    }

    @Override
    public List<UsersDto> findAll() {
        return usersRepository.findAll()
                .stream()
                .map(usersConverter::fromUserToUserDTO)
                .collect(Collectors.toList());
    }

    private void validateUserDto(UsersDto usersDto) throws ValidationException {
        if (usersDto == null){
            throw new ValidationException("Object user is null");
        }
        if (usersDto.getLogin() == null || usersDto.getLogin().isEmpty()){
            throw new ValidationException("Login is empty");
        }
    }


}
