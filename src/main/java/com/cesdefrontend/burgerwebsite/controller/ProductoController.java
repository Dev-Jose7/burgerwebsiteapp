package com.cesdefrontend.burgerwebsite.controller;

import com.cesdefrontend.burgerwebsite.model.Producto;
import com.cesdefrontend.burgerwebsite.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    // Obtener todos los productos
    @GetMapping("/todos")
    public ResponseEntity<List<Producto>> getProducts() {
        List<Producto> productos = productoService.getProducts();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Integer id) {
        Optional<Producto> producto = productoService.getProductById(id);
        return producto.map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        // El propósito de map() es transformar ese valor en otro valor
    }

    // Crear un nuevo producto
    @PostMapping("/nuevo")
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        Producto createdProducto = productoService.createProduct(producto);
        return new ResponseEntity<>(createdProducto, HttpStatus.CREATED);
    }

    // Metodo para actualizar un producto
    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        Optional<Producto> object = productoService.getProductById(id);

        if(object.isPresent()){
            Producto updatedProducto = productoService.updateProduct(id, producto);
            return new ResponseEntity<>(updatedProducto, HttpStatus.OK); // 200 Success
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }

    // Eliminar un producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Integer id) {
        Optional<Producto> producto = productoService.getProductById(id);
        if (producto.isPresent()) {
            productoService.deleteProduct(producto.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // 204 No Content
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // 404 Not Found
        }
    }
}
