package com.cesdefrontend.burgerwebsite.repository;

import com.cesdefrontend.burgerwebsite.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    // Spring Data JPA podrá manejar automáticamente las operaciones de la base de datos con el tipo correcto (Producto se refiere al tipo de dato de la entidad a gestionar y el Integer se refiere al tipo de dato de la clave primaria Id).
    // Esta interfaz extiende JpaRepository, permitiendo tener acceso a una serie de métodos predefinidos para trabajar con una entidad (en este caso Producto) en la base de datos.
}
