package com.libruarys.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "ordenes")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden")
    private Integer id;

    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "id_libro")
    private Integer idLibro;

    @Column(name = "id_libreria")
    private Integer idLibreria;

    private Integer cantidad;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    private Double total;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getIdCliente() { return idCliente; }
    public void setIdCliente(Integer idCliente) { this.idCliente = idCliente; }

    public Integer getIdLibro() { return idLibro; }
    public void setIdLibro(Integer idLibro) { this.idLibro = idLibro; }

    public Integer getIdLibreria() { return idLibreria; }
    public void setIdLibreria(Integer idLibreria) { this.idLibreria = idLibreria; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public LocalDate getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDate fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
}