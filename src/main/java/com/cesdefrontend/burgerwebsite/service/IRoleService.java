package com.cesdefrontend.burgerwebsite.service;

import com.cesdefrontend.burgerwebsite.model.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    Role createRole(Role user);
    List<Role> getRoles();
    Optional<Role> getRoleById(Integer id);
    Optional<Role> getRoleByUser(String user);
    Role updateRole(Integer id, Role role);
    void deleteRole(Role user);
}
