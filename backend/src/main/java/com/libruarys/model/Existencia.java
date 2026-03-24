package com.libruarys.model;

import jakarta.persistence.*;
//liz
@Entity
@Table(name = "existencia")
public class Existencia {

    @EmbeddedId
    private ExistenciaId id;

    @Column(name = "cantidad")
    private Integer cantidad;

    public Existencia() {}

    public Existencia(ExistenciaId id, Integer cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public ExistenciaId getId() { return id; }
    public void setId(ExistenciaId id) { this.id = id; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
}