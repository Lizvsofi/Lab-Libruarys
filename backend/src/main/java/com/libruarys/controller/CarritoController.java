package com.libruarys.controller;

import com.libruarys.model.Existencia;
import com.libruarys.model.Libro;
import com.libruarys.model.Orden;
import com.libruarys.repository.ExistenciaRepository;
import com.libruarys.repository.LibroRepository;
import com.libruarys.repository.OrdenRepository; // Nueva importación
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
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

    @Autowired
    private OrdenRepository ordenRepository; // Nuevo repositorio para órdenes

    @PostMapping("/comprar")
@Transactional
public ResponseEntity<?> comprar(@RequestBody CompraRequest compra) {
    try {
        System.out.println("=== INICIO DE COMPRA ===");
        System.out.println("idLibreria: " + compra.getIdLibreria());
        System.out.println("idCliente: " + compra.getIdCliente());

        if (compra.getIdLibreria() == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Falta especificar el ID de la librería."));
        }

        if (compra.getIdCliente() == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Falta especificar el ID del cliente."));
        }

        for (CompraRequest.ItemCompra item : compra.getItems()) {
            System.out.println("Procesando libro ID: " + item.getId() + ", cantidad: " + item.getCantidad());

            // ... código de stock ...

            // 2. Registrar la orden
            Optional<Libro> libroOpt = libroRepository.findById(item.getId());
            if (libroOpt.isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of("error", "El libro ID " + item.getId() + " no existe."));
            }
            Libro libro = libroOpt.get();

            Orden orden = new Orden();
            orden.setIdCliente(compra.getIdCliente());
            orden.setIdLibro(item.getId());
            orden.setIdLibreria(compra.getIdLibreria());
            orden.setCantidad(item.getCantidad());
            orden.setFechaCreacion(LocalDate.now());

            double total = libro.getPrecio().doubleValue() * item.getCantidad();
            orden.setTotal(total);
            System.out.println("Total calculado: " + total);

            System.out.println("Guardando orden...");
            ordenRepository.save(orden);
            ordenRepository.flush(); // fuerza la ejecución inmediata de la consulta
            System.out.println("Orden guardada con ID: " + orden.getId());
        }
        System.out.println("=== FIN DE COMPRA ===");
        return ResponseEntity.ok(Map.of("mensaje", "Compra realizada con éxito"));
    } catch (Exception e) {
        e.printStackTrace();  // Esto imprimirá el error completo en la consola
        return ResponseEntity.status(500).body(Map.of("error", "Error en el servidor: " + e.getMessage()));
    }
}

    public static class CompraRequest {
        private Integer idLibreria;
        private Integer idCliente; // Nuevo campo para identificar al cliente
        private List<ItemCompra> items;

        public Integer getIdLibreria() { return idLibreria; }
        public void setIdLibreria(Integer idLibreria) { this.idLibreria = idLibreria; }

        public Integer getIdCliente() { return idCliente; }
        public void setIdCliente(Integer idCliente) { this.idCliente = idCliente; }

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