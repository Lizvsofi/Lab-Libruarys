package com.libruarys.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros") // Nombre de la tabla en MySQL
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro") // Nombre exacto en MySQL
    private Integer id;

    @Column(name = "nombre") // En tu DB se llama 'nombre'
    private String titulo;

    private String autor;
    
    private String categoria;
    
    private Double precio;

    // Estos campos existen en tu MySQL, los agrego por si los necesitas
    private String edicion;
    private String editorial;

    // Constructor vacío (obligatorio para JPA)
    public Libro() {}

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
}