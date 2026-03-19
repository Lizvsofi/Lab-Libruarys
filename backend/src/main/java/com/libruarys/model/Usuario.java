package com.libruarys.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id;

    private String nombre;

    @Column(name = "apellido") // Coincide con tu MySQL
    private String apellidos;

    private String correo;
    private String telefono;

    @Column(name = "fecha_nac") // Coincide con tu MySQL
    private String fechaNacimiento;

    private String direccion;

    @Column(name = "codigo_postal") // Coincide con tu MySQL
    private String codigoPostal;

    @Column(name = "cotrasena") // Coincide con tu MySQL
    private String cotrasena;

    // --- Getters y Setters Corregidos ---
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }
    
    // IMPORTANTE: El nombre del método ahora coincide con lo que busca el Controller
    public String getCotrasena() { return cotrasena; }
    public void setCotrasena(String cotrasena) { this.cotrasena = cotrasena; }
}