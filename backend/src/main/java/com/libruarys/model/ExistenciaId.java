package com.libruarys.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ExistenciaId implements Serializable {

    @Column(name = "id_libreria")
    private Integer idLibreria;

    @Column(name = "id_libro")
    private Integer idLibro;

    // Constructores
    public ExistenciaId() {}

    public ExistenciaId(Integer idLibreria, Integer idLibro) {
        this.idLibreria = idLibreria;
        this.idLibro = idLibro;
    }

    // Getters y Setters
    public Integer getIdLibreria() { return idLibreria; }
    public void setIdLibreria(Integer idLibreria) { this.idLibreria = idLibreria; }

    public Integer getIdLibro() { return idLibro; }
    public void setIdLibro(Integer idLibro) { this.idLibro = idLibro; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExistenciaId that = (ExistenciaId) o;
        return Objects.equals(idLibreria, that.idLibreria) &&
               Objects.equals(idLibro, that.idLibro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLibreria, idLibro);
    }
}