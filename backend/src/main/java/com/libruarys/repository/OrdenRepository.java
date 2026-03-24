package com.libruarys.repository;

import com.libruarys.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrdenRepository extends JpaRepository<Orden, Integer> {
    List<Orden> findByIdCliente(Integer idCliente);
    List<Orden> findByIdLibreria(Integer idLibreria);
    List<Orden> findByIdLibro(Integer idLibro);
}