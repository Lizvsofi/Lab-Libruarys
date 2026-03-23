package com.libruarys.controller;

import com.libruarys.repository.ExistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/existencias")
@CrossOrigin(origins = "*")
public class ExistenciaController {

    @Autowired
    private ExistenciaRepository existenciaRepository;

    @GetMapping("/{idLibreria}/{idLibro}")
    public ResponseEntity<?> getStock(@PathVariable Integer idLibreria, @PathVariable Integer idLibro) {
        return existenciaRepository.findById_IdLibreriaAndId_IdLibro(idLibreria, idLibro)
                .map(e -> ResponseEntity.ok(Map.of("cantidad", e.getCantidad())))
                .orElse(ResponseEntity.ok(Map.of("cantidad", 0)));
    }
}