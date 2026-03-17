async function validarRegistro(event) {
    event.preventDefault(); 

    const pass1 = document.getElementById("pass1").value;
    const pass2 = document.getElementById("pass2").value;

    if (pass1 !== pass2) {
        alert("Las contraseñas no coinciden. Por favor, verifica.");
        return false;
    }

    // En tu archivo AnaJS.js, el objeto debe verse así:
const usuarioData = {
    nombre: document.getElementById("nombre").value,
    apellidos: document.getElementById("apellidos").value,
    correo: document.getElementById("correo").value,
    telefono: document.getElementById("telefono").value,
    fechaNacimiento: document.getElementById("fechaNacimiento").value,
    direccion: document.getElementById("direccion").value,
    codigoPostal: document.getElementById("codigoPostal").value,
    contrasena: pass1 // <-- ASEGÚRATE DE QUE AQUÍ DIGA 'contrasena'
};

    try {
        const response = await fetch('http://localhost:8080/api/usuarios/registro', {
            method: 'POST',
            headers: { 
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            body: JSON.stringify(usuarioData)
        });

        if (response.ok) {
            alert("¡Registro exitoso! Ya estás en la base de datos de Libruarys.");
            window.location.href = "Iniciousuario.html"; 
        } else {
            const errorData = await response.json();
            alert("Error: " + (errorData.error || "No se pudo registrar el usuario"));
        }
    } catch (error) {
        console.error("Error de conexión:", error);
        alert("No hay conexión con el servidor. Verifica que Spring Boot esté activo.");
    }
}

async function validarLogin(event) {
    event.preventDefault();

    const datos = {
    nombre: document.getElementById("nombre").value,
    // ... otros campos ...
    contrasena: document.getElementById("pass1").value // Asegúrate de que sea 'contrasena'
};

    try {
        const response = await fetch('http://localhost:8080/api/usuarios/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(datosLogin)
        });

        if (response.ok) {
            const usuario = await response.json();
            alert("¡Bienvenido, " + usuario.nombre + "!");
            localStorage.setItem("nombreUsuario", usuario.nombre);
            window.location.href = "catalogo_accion_usua.html";
        } else {
            alert("Correo o contraseña incorrectos.");
        }
    } catch (error) {
        alert("Error al conectar con el servidor.");
    }
}