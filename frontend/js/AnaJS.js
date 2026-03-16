function toggleMenu() {
  const menu = document.getElementById("navLinks");
  menu.classList.toggle("active");
}

function toggleDropdown(event) {
  event.preventDefault(); 
  document.getElementById("submenu").classList.toggle("show");
}

// Validación para  las contraseñas inicio de registro
function validarRegistro(event) {
    const pass1 = document.getElementById("pass1").value;
    const pass2 = document.getElementById("pass2").value;

    if (pass1 !== pass2) {
        event.preventDefault(); 
        alert("Las contraseñas no coinciden. Por favor, verifica.");
        return false;
    }
    alert("¡Registro exitoso!");
    return true;
}

//validacion para editar perfil
function confirmarCambios(event) {
    event.preventDefault(); // Evita que la página recargue al hacer clic
    
    const pass1 = document.getElementById("pass1").value;
    const pass2 = document.getElementById("pass2").value;

    // 1. Primero validamos si las contraseñas coinciden
    if (pass1 !== pass2) {
        alert("Las contraseñas no coinciden. Por favor, verifica.");
        return; // Detiene la función aquí
    }

    // 2. Si coinciden (o si están vacías porque el usuario no quiso cambiarlas), confirmamos
    alert("¡Tus cambios han sido guardados exitosamente!");
    
}