package com.libruarys.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    private String categoria;

    @Column(nullable = false)
    private Double precio;

    private String edicion;
    private String editorial;

    // Campo para la ruta de la imagen (ej: "img/it.jpg")
    @Column(name = "imagen")
    private String imagen;

    // Campo para el inventario/stock que aparece en tus archivos HTML
    @Column(name = "cantidad")
    private Integer cantidad;

    // Constructor vacío (obligatorio para JPA)
    public Libro() {}

    // Constructor con parámetros para facilitar pruebas
    public Libro(String titulo, String autor, Double precio, String categoria, Integer cantidad) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.categoria = categoria;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public String getEdicion() { return edicion; }
    public void setEdicion(String edicion) { this.edicion = edicion; }

    public String getEditorial() { return editorial; }
    public void setEditorial(String editorial) { this.editorial = editorial; }

    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
}