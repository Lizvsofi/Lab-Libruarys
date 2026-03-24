package com.libruarys.controller;

import com.libruarys.model.Libreria;
import com.libruarys.repository.LibreriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/librerias")
@CrossOrigin(origins = "*")
public class LibreriaController {

    @Autowired
    private LibreriaRepository libreriaRepository;

    // GET: Obtener todas las librerías
    @GetMapping
    public List<Libreria> getAllLibrerias() {
        return libreriaRepository.findAll();
    }

    // GET: Obtener una librería por ID
    @GetMapping("/{id}")
    public ResponseEntity<Libreria> getLibreriaById(@PathVariable Integer id) {
        return libreriaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}