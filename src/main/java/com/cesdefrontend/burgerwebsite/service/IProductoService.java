package com.cesdefrontend.burgerwebsite.service;

import com.cesdefrontend.burgerwebsite.model.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    List<Producto> getProducts();
    Optional<Producto> getProductById(Integer id);
    Producto saveProduct(Producto product);
    void deleteProduct(Producto product);
}
