package com.libruarys.controller;

import com.libruarys.model.Libro;
import com.libruarys.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin(origins = "*")
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;
// Obtener todos los libros
    @GetMapping
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }
//Obtener libros por categoría
    @GetMapping("/categoria/{categoria}")
    public List<Libro> getLibrosByCategoria(@PathVariable String categoria) {
        return libroRepository.findByCategoria(categoria);
    }
//Obtener un libro por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Integer id) {
        Optional<Libro> libro = libroRepository.findById(id);
        return libro.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
//Crear un nuevo libro
    @PostMapping
    public ResponseEntity<?> createLibro(@RequestBody Libro libro) {
        try {
            Libro saved = libroRepository.save(libro);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.status(500).body(errorResponse);
        }
    }
//Actualizar un libro existente

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLibro(@PathVariable Integer id, @RequestBody Libro libro) {
        try {
            if (!libroRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            libro.setId(id);
            Libro updated = libroRepository.save(libro);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.status(500).body(errorResponse);
        }
    }
  // Eliminar un libro
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLibro(@PathVariable Integer id) {
        try {
            if (!libroRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            libroRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.status(500).body(errorResponse);
        }
    }
}