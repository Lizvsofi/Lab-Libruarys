package com.libruarys.controller;

import com.libruarys.model.Libro;
import com.libruarys.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin(origins = "*") // Esto permite que tus HTML se comuniquen con Java
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    // Este método devuelve los libros según la categoría (Acción, Terror, etc.)
    @GetMapping("/categoria/{nombreCategoria}")
    public List<Libro> obtenerPorCategoria(@PathVariable String nombreCategoria) {
        return libroRepository.findByCategoria(nombreCategoria);
    }

    // Este método devuelve todos los libros
    @GetMapping
    public List<Libro> obtenerTodos() {
        return libroRepository.findAll();
    }
}