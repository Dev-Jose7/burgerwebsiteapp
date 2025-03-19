package com.cesdefrontend.burgerwebsite.service;

import com.cesdefrontend.burgerwebsite.model.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    List<Role> getRoles();
    Optional<Role> geRoleById();
    Role savRole();
    void deletRole();
}
