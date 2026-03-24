package com.libruarys.controller;

import com.libruarys.model.Existencia;
import com.libruarys.repository.ExistenciaRepository;
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

    @Autowired
    private ExistenciaRepository existenciaRepository;

    @PostMapping("/comprar")
    @Transactional
    public ResponseEntity<?> comprar(@RequestBody CompraRequest compra) {
        try {
            if (compra.getIdLibreria() == null) {
                return ResponseEntity.badRequest().body(Map.of("error", "Falta especificar el ID de la librería."));
            }

            for (CompraRequest.ItemCompra item : compra.getItems()) {
                // CAMBIO APLICADO: Se usa findById_IdLibreriaAndId_IdLibro para coincidir con el Repository
                Optional<Existencia> existenciaOpt = existenciaRepository.findById_IdLibreriaAndId_IdLibro(
                    compra.getIdLibreria(), 
                    item.getId()
                );

                if (existenciaOpt.isPresent()) {
                    Existencia existencia = existenciaOpt.get();
                    
                    // Validamos stock
                    if (existencia.getCantidad() < item.getCantidad()) {
                        return ResponseEntity.badRequest().body(Map.of("error", "Stock insuficiente en la sucursal para el libro ID: " + item.getId()));
                    }

                    // DESCUENTO REAL: Actualización de la tabla 'existencia'
                    existencia.setCantidad(existencia.getCantidad() - item.getCantidad());
                    existenciaRepository.save(existencia); 
                } else {
                    return ResponseEntity.badRequest().body(Map.of("error", "El libro ID " + item.getId() + " no está registrado en esta sucursal."));
                }
            }
            return ResponseEntity.ok(Map.of("mensaje", "Compra realizada con éxito"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", "Error en el servidor: " + e.getMessage()));
        }
    }

    public static class CompraRequest {
        private Integer idLibreria; 
        private List<ItemCompra> items;

        public Integer getIdLibreria() { return idLibreria; }
        public void setIdLibreria(Integer idLibreria) { this.idLibreria = idLibreria; }

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