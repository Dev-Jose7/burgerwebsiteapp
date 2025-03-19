package com.cesdefrontend.burgerwebsite.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private String imagen;

    @Column(name = "created_at", updatable = false) // El campo 'created_at' no debe actualizarse por eso updatable es false
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updateAt;

    // Este metodo se ejecutará antes de insertar el registro, para asegurar que se establezcan las fechas automáticamente
    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now(); // Establece 'createdAt' al momento de la inserción
        updateAt = LocalDateTime.now();  // Establece 'updateAt' también en la inserción inicial
    }

    // Este metodo se ejecutará antes de actualizar el registro, para actualizar la fecha 'updated_at'
    @PreUpdate
    public void preUpdate() {
        updateAt = LocalDateTime.now(); // Actualiza 'updateAt' al momento de la actualización
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", imagen='" + imagen + '\'' +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
