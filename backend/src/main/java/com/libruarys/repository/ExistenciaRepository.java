package com.libruarys.repository;

import com.libruarys.model.Existencia;
import com.libruarys.model.ExistenciaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;   // <-- IMPORTANTE: agregar esta importación

@Repository
public interface ExistenciaRepository extends JpaRepository<Existencia, ExistenciaId> {
    // Método correcto para buscar por id_libreria e id_libro
    Optional<Existencia> findByIdIdLibreriaAndIdIdLibro(Integer idLibreria, Integer idLibro);
    
    // Método para buscar todas las existencias de un libro (sin importar librería)
    List<Existencia> findByIdIdLibro(Integer idLibro);
}