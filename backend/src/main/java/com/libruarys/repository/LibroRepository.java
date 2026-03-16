package com.libruarys.repository;

import com.libruarys.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
    // Este método buscará libros por categoría (Acción, Terror, etc.)
    List<Libro> findByCategoria(String categoria);
}