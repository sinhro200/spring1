package com.sinhro.spring1.controller;

import com.sinhro.spring1.dto.UsersDto;
import com.sinhro.spring1.exception.ValidationException;
import com.sinhro.spring1.service.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // = @Controller + @ RequestBody
@RequestMapping("/users")
@AllArgsConstructor
@Log//Создаёт : private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(LogExample.class.getName());
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/save")
    public UsersDto saveUsers(@RequestBody UsersDto usersDto) throws ValidationException {
        log.info("handling save users: " + usersDto);
        return usersService.saveUser(usersDto);
    }

    @GetMapping("/findAll")
    public List<UsersDto> findAllUsers(){
        log.info("Handling find all users request");
        return usersService.findAll();
    }

    @GetMapping("/findByLogin")
    public UsersDto findByLogin(@RequestParam String login){
        log.info("Handling find by login request: " + login);
        return usersService.findByLogin(login);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        log.info("Handling delete user request: " + id);
        usersService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
