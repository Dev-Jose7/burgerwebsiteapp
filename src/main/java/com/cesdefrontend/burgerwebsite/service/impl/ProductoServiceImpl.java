package com.cesdefrontend.burgerwebsite.service.impl;

import com.cesdefrontend.burgerwebsite.model.Producto;
import com.cesdefrontend.burgerwebsite.repository.ProductoRepository;
import com.cesdefrontend.burgerwebsite.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> getProducts() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> getProductById(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto saveProduct(Producto product) {
        return productoRepository.save(product);
    }

    @Override
    public void deleteProduct(Producto product) {
        productoRepository.delete(product);
    }
}
