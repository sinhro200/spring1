package com.sinhro.spring1.dto;


import com.sinhro.spring1.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Builder //реализовывает паттерн билдер
@Data   //For getters, setters
public class UsersDto {

    private Integer id;
    private String name;
    private String login;
    private String password;
    private String passwordConfirm;
    private String email;
    private Set<Role> roles;
}
