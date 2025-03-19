package com.cesdefrontend.burgerwebsite.repository;

import com.cesdefrontend.burgerwebsite.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByUsuario(String name);
}
