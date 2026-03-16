package com.libruarys.controller;

import com.libruarys.model.Usuario;
import com.libruarys.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // Importante para manejar respuestas de error
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // MÉTODO DE REGISTRO (El que ya tienes y funciona)
    @PostMapping("/registro")
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // MÉTODO DE LOGIN (La lógica nueva)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario datosLogin) {
        // 1. Buscamos en MySQL si existe un usuario con ese correo
        Usuario usuarioEncontrado = usuarioRepository.findByCorreo(datosLogin.getCorreo());

        // 2. Si el buscador no encuentra nada, mandamos un error
        if (usuarioEncontrado == null) {
            return ResponseEntity.status(401).body("El correo no existe");
        }

        // 3. Si existe, comparamos la contraseña enviada con la de la base de datos
        if (usuarioEncontrado.getContraseña().equals(datosLogin.getContraseña())) {
            // Si coinciden, login exitoso
            return ResponseEntity.ok(usuarioEncontrado);
        } else {
            // Si no coinciden, mandamos error de contraseña
            return ResponseEntity.status(401).body("Contraseña incorrecta");
        }
    }

    @GetMapping("/registro")
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }
}