function toggleMenu() {
  const menu = document.getElementById("navLinks");
  menu.classList.toggle("active");
}

function toggleDropdown(event) {
  event.preventDefault(); 
  document.getElementById("submenu").classList.toggle("show");
}

// ESTA ES LA FUNCIÓN QUE VAMOS A ACTUALIZAR PARA CONECTAR CON JAVA
async function validarRegistro(event) {
    event.preventDefault(); // Evitamos que la página se recargue inmediatamente

    const pass1 = document.getElementById("pass1").value;
    const pass2 = document.getElementById("pass2").value;

    // 1. Validación de contraseñas
    if (pass1 !== pass2) {
        alert("Las contraseñas no coinciden. Por favor, verifica.");
        return false;
    }

    // 2. Captura de todos los datos del formulario (deben coincidir con Usuario.java)
    const usuarioData = {
        nombre: document.querySelector('input[id="nombre"]').value,
        apellidos: document.querySelector('input[id="apellidos"]').value,
        correo: document.querySelector('input[id="correo"]').value,
        telefono: document.querySelector('input[id="telefono"]').value,
        fechaNacimiento: document.querySelector('input[id="fechaNacimiento"]').value,
        direccion: document.querySelector('input[id="direccion"]').value,
        codigoPostal: document.querySelector('input[id="codigoPostal"]').value,
        contraseña: pass1
    };

    try {
        // 3. Envío de datos al Backend de Spring Boot
        const response = await fetch('http://localhost:8080/api/usuarios/registro', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(usuarioData)
        });

        if (response.ok) {
            alert("¡Registro exitoso! Ya estás en la base de datos de Libruarys.");
            window.location.href = "Iniciousuario.html"; // Nos lleva a la página de usuario
        } else {
            alert("Error al guardar en la base de datos. Código: " + response.status);
        }
    } catch (error) {
        console.error("Error:", error);
        alert("No se pudo conectar con el servidor Java. Asegúrate de que esté corriendo.");
    }
}

// Validación para editar perfil
function confirmarCambios(event) {
    event.preventDefault();
    const pass1 = document.getElementById("pass1").value;
    const pass2 = document.getElementById("pass2").value;

    if (pass1 !== pass2) {
        alert("Las contraseñas no coinciden. Por favor, verifica.");
        return;
    }
    alert("¡Tus cambios han sido guardados exitosamente!");
}