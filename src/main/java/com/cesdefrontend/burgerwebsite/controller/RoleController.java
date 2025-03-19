package com.cesdefrontend.burgerwebsite.controller;

import com.cesdefrontend.burgerwebsite.model.Role;
import com.cesdefrontend.burgerwebsite.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    // Obtener todos los productos
    @GetMapping("/todos")
    public ResponseEntity<List<Role>> getRoles(){
        List<Role> roles = roleService.getRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Integer id) {
        Optional<Role> role = roleService.getRoleById(id);
        return role.map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        // El propósito de map() es transformar ese valor en otro valor
    }

    // Crear un nuevo producto
    @PostMapping("/nuevo")
    public ResponseEntity<?> createRole(@RequestBody Role role) {
        Optional<Role> object = roleService.getRoleByUser(role.getUsuario());

        if (object.isEmpty()) {
            // Si el usuario no existe, se crea el nuevo rol
            Role createdRole = roleService.createRole(role);
            return new ResponseEntity<>(createdRole, HttpStatus.CREATED); // 201 Created
        } else {
            // Si ya existe un usuario con el mismo nickname, se devuelve 409 Conflict con un mensaje
            return new ResponseEntity<>("Ya existe un usuario registrado bajo este nickname", HttpStatus.CONFLICT); // 201 CONFLICT
        }
    }

    // Metodo para actualizar un producto
    @PutMapping("/{id}")
    public ResponseEntity<Role> updateProducto(@PathVariable Integer id, @RequestBody Role role) {
        Optional<Role> object = roleService.getRoleById(id);

        if(object.isPresent()){
            Role updatedProducto = roleService.updateRole(id, role);
            return new ResponseEntity<>(updatedProducto, HttpStatus.OK); // 204 Success
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }

    // Eliminar un producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Integer id) {
        Optional<Role> role = roleService.getRoleById(id);
        if (role.isPresent()) {
            roleService.deleteRole(role.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // 204 No Content
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // 404 Not Found
        }
    }
}
