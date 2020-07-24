package com.sinhro.spring1.repository;

import com.sinhro.spring1.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    CRUD методы по работе с сущностью уже встроенны в JpaRepository и писать их самому не нужно.
    Такие методы как save(), saveAll(), delete(), findById() готовы к использованию
 */
public interface UsersRepository extends JpaRepository<Users,Integer> {

    Users findByLogin(String login);
}
