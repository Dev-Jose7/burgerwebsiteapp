package com.cesdefrontend.burgerwebsite.service.impl;

import com.cesdefrontend.burgerwebsite.model.Role;
import com.cesdefrontend.burgerwebsite.repository.RoleRepository;
import com.cesdefrontend.burgerwebsite.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> getRoleById(Integer id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role saveRole(Role user) {
        return roleRepository.save(user);
    }

    @Override
    public void deleteRole(Role user) {
        roleRepository.delete(user);
    }
}
