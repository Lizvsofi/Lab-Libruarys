package com.libruarys.repository;

import com.libruarys.model.Existencia;
import com.libruarys.model.ExistenciaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ExistenciaRepository extends JpaRepository<Existencia, ExistenciaId> {
    // Busca por los campos internos de la llave compuesta
    Optional<Existencia> findById_IdLibreriaAndId_IdLibro(Integer idLibreria, Integer idLibro);
}