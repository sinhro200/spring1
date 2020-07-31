package com.sinhro.spring1.controller;

import com.sinhro.spring1.dto.UsersDto;
import com.sinhro.spring1.entity.Users;
import com.sinhro.spring1.exception.ValidationException;
import com.sinhro.spring1.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UsersService userService;

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("userForm",new UsersDto());

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(
            @ModelAttribute("userForm") @Valid UsersDto userForm,
            BindingResult bindingResult, Model model
    ) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }
        try{
            if (!userService.saveUser(userForm)){
                model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
                return "registration";
            }
        }catch (ValidationException e){
            model.addAttribute("usernameError", e.getMessage());
        }


        return "redirect:/";
    }
}
