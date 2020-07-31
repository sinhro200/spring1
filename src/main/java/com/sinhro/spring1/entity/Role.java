package com.sinhro.spring1.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_role")
@Data
@NoArgsConstructor
@Getter
public class Role implements GrantedAuthority {

    @Id
    private long id;

    private String name;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<Users> users;

    public Role(Long id) {
        this.id = id;
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
