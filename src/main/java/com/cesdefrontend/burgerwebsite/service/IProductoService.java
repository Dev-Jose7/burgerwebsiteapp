package com.cesdefrontend.burgerwebsite.service;

import com.cesdefrontend.burgerwebsite.model.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    Producto createProduct(Producto product);
    List<Producto> getProducts();
    Optional<Producto> getProductById(Integer id);
    Producto updateProduct(Integer id, Producto producto);
    void deleteProduct(Producto product);
}
