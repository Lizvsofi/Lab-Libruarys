package com.libruarys.controller;

import com.libruarys.model.Orden;
import com.libruarys.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ordenes")
@CrossOrigin(origins = "*")
public class OrdenController {

    @Autowired
    private OrdenRepository ordenRepository;

    // GET: Obtener todas las órdenes (para administrador)
    @GetMapping
    public List<Orden> getAllOrdenes() {
        return ordenRepository.findAll();
    }

    // GET: Obtener una orden por ID
    @GetMapping("/{id}")
    public ResponseEntity<Orden> getOrdenById(@PathVariable Integer id) {
        Optional<Orden> orden = ordenRepository.findById(id);
        return orden.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // GET: Órdenes de un cliente específico
    @GetMapping("/cliente/{idCliente}")
    public List<Orden> getOrdenesByCliente(@PathVariable Integer idCliente) {
        return ordenRepository.findByIdCliente(idCliente);
    }

    // GET: Órdenes de una librería
    @GetMapping("/libreria/{idLibreria}")
    public List<Orden> getOrdenesByLibreria(@PathVariable Integer idLibreria) {
        return ordenRepository.findByIdLibreria(idLibreria);
    }

    // POST: Crear una nueva orden (útil para pruebas, pero normalmente se crea al comprar)
    @PostMapping
    public ResponseEntity<Orden> createOrden(@RequestBody Orden orden) {
        Orden saved = ordenRepository.save(orden);
        return ResponseEntity.ok(saved);
    }
}