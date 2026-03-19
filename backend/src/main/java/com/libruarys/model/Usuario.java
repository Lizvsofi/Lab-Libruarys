package com.libruarys.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id; // CAMBIO: De Long a Integer para que coincida con MySQL

    private String nombre;
    private String correo;

    @Column(name = "cotrasena") 
    private String password;

    // Getters y Setters corregidos
    public Integer getId() { return id; } // CAMBIO: Integer
    public void setId(Integer id) { this.id = id; } // CAMBIO: Integer
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}