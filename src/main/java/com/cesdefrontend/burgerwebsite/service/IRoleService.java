package com.cesdefrontend.burgerwebsite.service;

import com.cesdefrontend.burgerwebsite.model.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    List<Role> getRoles();
    Optional<Role> getRoleById(Integer id);
    Role saveRole(Role user);
    void deleteRole(Role user);
}
