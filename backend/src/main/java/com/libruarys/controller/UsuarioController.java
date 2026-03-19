package com.libruarys.controller;

import com.libruarys.model.Usuario;
import com.libruarys.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*") // Para que tu HTML pueda comunicarse
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credenciales) {
        String correo = credenciales.get("correo");
        String contrasena = credenciales.get("contrasena");

        Optional<Usuario> userOpt = usuarioRepository.findByCorreo(correo);

        if (userOpt.isPresent() && userOpt.get().getPassword().equals(contrasena)) {
            // Retornamos el usuario si coincide
            return ResponseEntity.ok(userOpt.get());
        }
        
        // Retornamos error si no coincide
        return ResponseEntity.status(401).body(Map.of("error", "Credenciales incorrectas"));
    }
}