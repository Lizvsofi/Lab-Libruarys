package com.libruarys.controller;

import com.libruarys.model.Libreria;
import com.libruarys.model.Usuario;
import com.libruarys.repository.LibreriaRepository;
import com.libruarys.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*") 
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LibreriaRepository libreriaRepository; 

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credenciales) {
        String correo = credenciales.get("correo");
        String contrasena = credenciales.get("contrasena");

        // 1. Intentamos buscar primero en la tabla de CLIENTES (Usuarios)
        Optional<Usuario> userOpt = usuarioRepository.findByCorreo(correo);
        
        if (userOpt.isPresent()) {
            Usuario usuario = userOpt.get(); // <-- Aquí se declara 'usuario'
            if (usuario.getCotrasena().equals(contrasena)) {
                return ResponseEntity.ok(Map.of(
                    "nombre", usuario.getNombre(),
                    "redirect", "generos_usua.html",  // Para clientes
                    "rol", "USUARIO"
                ));
            }
        }

        // 2. Si no se encontró como cliente, buscamos en la tabla de LIBRERIAS
        Optional<Libreria> libOpt = libreriaRepository.findByCorreo(correo);
        
        if (libOpt.isPresent()) {
            Libreria libreria = libOpt.get(); // <-- Aquí se declara 'libreria'
            if (libreria.getCotrasena().equals(contrasena)) {
                return ResponseEntity.ok(Map.of(
                    "nombre", libreria.getContacto(),
                    "redirect", "generos_admin.html", // Para librerías
                    "rol", "ADMIN"
                ));
            }
        }
        
        // 3. Error si no coincide nada
        return ResponseEntity.status(401).body(Map.of("error", "Correo o contraseña incorrectos"));
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody Usuario nuevoUsuario) {
        try {
            Usuario guardado = usuarioRepository.save(nuevoUsuario);
            return ResponseEntity.ok(guardado);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", "Error al guardar"));
        }
    }
}