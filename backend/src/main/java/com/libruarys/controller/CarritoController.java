package com.libruarys.controller;

import com.libruarys.model.Libro;
import com.libruarys.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/carrito")
@CrossOrigin(origins = "*")
public class CarritoController {

    @Autowired
    private LibroRepository libroRepository;

    @PostMapping("/comprar")
    @Transactional
    public ResponseEntity<?> comprar(@RequestBody CompraRequest compra) {
        try {
            for (CompraRequest.ItemCompra item : compra.getItems()) {
                Optional<Libro> optional = libroRepository.findById(item.getId());
                if (!optional.isPresent()) {
                    return ResponseEntity.badRequest().body(Map.of("error", "Libro no encontrado: " + item.getId()));
                }
                Libro libro = optional.get();
                if (libro.getCantidad() < item.getCantidad()) {
                    return ResponseEntity.badRequest().body(Map.of("error", "Stock insuficiente para " + libro.getTitulo()));
                }
                libro.setCantidad(libro.getCantidad() - item.getCantidad());
                libroRepository.save(libro);
            }
            return ResponseEntity.ok(Map.of("mensaje", "Compra realizada con éxito"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", "Error al procesar la compra: " + e.getMessage()));
        }
    }

    // Clase interna para recibir los datos
    public static class CompraRequest {
        private List<ItemCompra> items;

        public List<ItemCompra> getItems() { return items; }
        public void setItems(List<ItemCompra> items) { this.items = items; }

        public static class ItemCompra {
            private Integer id;
            private int cantidad;

            public Integer getId() { return id; }
            public void setId(Integer id) { this.id = id; }
            public int getCantidad() { return cantidad; }
            public void setCantidad(int cantidad) { this.cantidad = cantidad; }
        }
    }
}