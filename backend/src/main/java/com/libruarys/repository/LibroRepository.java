package com.libruarys.repository;

import com.libruarys.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
    List<Libro> findByCategoria(String categoria);
}