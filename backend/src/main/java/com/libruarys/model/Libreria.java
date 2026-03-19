package com.libruarys.model;

import jakarta.persistence.*;

@Entity
@Table(name = "librerias")
public class Libreria {

    @Id
    @Column(name = "id_libreria")
    private Integer id;

    private String ciudad;
    private String direccion;

    @Column(name = "contacto_libreria")
    private String contacto;

    @Column(name = "tel_libreria")
    private String telefono;

    private String correo;

    // Cambiado de 'contrasena' a 'cotrasena' para coincidir con la base de datos
    @Column(name = "cotrasena")
    private String cotrasena;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getContacto() { return contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    // Métodos actualizados para usar 'cotrasena'
    public String getCotrasena() { return cotrasena; }
    public void setCotrasena(String cotrasena) { this.cotrasena = cotrasena; }
}