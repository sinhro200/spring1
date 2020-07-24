package com.sinhro.spring1.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder //реализовывает паттерн билдер
@Data   //For getters, setters
public class UsersDto {

    private Integer id;
    private String name;
    private String login;
    private String email;
}
