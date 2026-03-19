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
    private String contrasena;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getContacto() { return contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
}