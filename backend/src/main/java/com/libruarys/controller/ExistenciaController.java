package com.libruarys.controller;

import com.libruarys.model.Existencia;
import com.libruarys.model.ExistenciaId;
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

    // Método existente para consultar stock (GET)
    @GetMapping("/{idLibreria}/{idLibro}")
    public ResponseEntity<?> getStock(@PathVariable Integer idLibreria, @PathVariable Integer idLibro) {
        return existenciaRepository.findById_IdLibreriaAndId_IdLibro(idLibreria, idLibro)
                .map(e -> ResponseEntity.ok(Map.of("cantidad", e.getCantidad())))
                .orElse(ResponseEntity.ok(Map.of("cantidad", 0)));
    }

    // NUEVO método para guardar/actualizar existencia (POST)
    @PostMapping
    public ResponseEntity<?> guardarExistencia(@RequestBody Map<String, Object> payload) {
        try {
            Integer idLibreria = (Integer) payload.get("id_libreria");
            Integer idLibro = (Integer) payload.get("id_libro");
            Integer cantidad = (Integer) payload.get("cantidad");

            if (idLibreria == null || idLibro == null || cantidad == null) {
                return ResponseEntity.badRequest().body(Map.of("error", "Faltan campos obligatorios: id_libreria, id_libro, cantidad"));
            }

            ExistenciaId id = new ExistenciaId(idLibreria, idLibro);
            Existencia existencia = existenciaRepository.findById(id).orElse(new Existencia());
            existencia.setId(id);
            existencia.setCantidad(cantidad);

            existenciaRepository.save(existencia);
            return ResponseEntity.ok(Map.of("mensaje", "Existencia guardada correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", "Error al guardar existencia: " + e.getMessage()));
        }
    }
}