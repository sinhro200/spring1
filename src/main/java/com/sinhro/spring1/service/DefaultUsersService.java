package com.sinhro.spring1.service;

import com.sinhro.spring1.dto.UsersDto;
import com.sinhro.spring1.entity.Role;
import com.sinhro.spring1.entity.Users;
import com.sinhro.spring1.exception.ValidationException;
import com.sinhro.spring1.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class DefaultUsersService implements UsersService{

    private final UsersRepository usersRepository;
    private final UsersConverter usersConverter;

    @Override
    public boolean saveUser(UsersDto usersDto) throws ValidationException {
        validateUserDto(usersDto);
        if (usersRepository.findByLogin(usersDto.getLogin()) != null) {
            return false;
        }

        usersDto.setRoles(Collections.singleton(new Role(1L,"ROLE_USER")));
        usersRepository.save(usersConverter.fromUserDtoToUser(usersDto));

        return true;
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


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users user = usersRepository.findByLogin(s);

        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
