package com.sinhro.spring1.repository;

import com.sinhro.spring1.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role,Integer> {
}
