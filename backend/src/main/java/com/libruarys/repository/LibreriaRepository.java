package com.libruarys.repository;

import com.libruarys.model.Libreria;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LibreriaRepository extends JpaRepository<Libreria, Integer> {
    // Esto permite buscar una tienda por su correo electrónico
    Optional<Libreria> findByCorreo(String correo);
}