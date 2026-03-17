package com.libruarys.controller;

import com.libruarys.model.Usuario;
import com.libruarys.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional; // Importante para resolver el error rojo

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*") 
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/registro")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario) {
        try {
            // Ajustado para usar isPresent() con Optional
            if (usuarioRepository.findByCorreo(usuario.getCorreo()).isPresent()) {
                return crearRespuestaError("El correo ya está registrado", HttpStatus.BAD_REQUEST);
            }
            
            Usuario nuevoUsuario = usuarioRepository.save(usuario);
            nuevoUsuario.setContrasena(null); 
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
        } catch (Exception e) {
            return crearRespuestaError("Error al registrar usuario: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario datosLogin) {
        if (datosLogin.getCorreo() == null || datosLogin.getContrasena() == null) {
            return crearRespuestaError("Correo y contraseña son obligatorios", HttpStatus.BAD_REQUEST);
        }

        // Buscamos al usuario usando Optional
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(datosLogin.getCorreo());

        // Verificamos si NO existe
        if (usuarioOpt.isEmpty()) {
            return crearRespuestaError("El correo no está registrado", HttpStatus.NOT_FOUND);
        }

        Usuario usuarioEncontrado = usuarioOpt.get();

        // Validación de contraseña (usando el nombre corregido: cotrasena)
        if (usuarioEncontrado.getContrasena().equals(datosLogin.getContrasena())) {
            usuarioEncontrado.setContrasena(null);
            return ResponseEntity.ok(usuarioEncontrado);
        } else {
            return crearRespuestaError("Contraseña incorrecta", HttpStatus.UNAUTHORIZED);
        }
    }

    private ResponseEntity<Map<String, String>> crearRespuestaError(String mensaje, HttpStatus status) {
        Map<String, String> error = new HashMap<>();
        error.put("error", mensaje);
        return ResponseEntity.status(status).body(error);
    }
}