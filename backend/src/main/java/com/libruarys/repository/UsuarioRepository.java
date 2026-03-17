package com.libruarys.repository;

import com.libruarys.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional; // <--- ESTA LÍNEA ES LA QUE FALTA

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Esto permite buscar al usuario para validar su contraseña
    Optional<Usuario> findByCorreo(String correo);
}