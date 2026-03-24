async function validarLogin(event) {
    event.preventDefault();

    const datosLogin = {
        correo: document.getElementById("correoLogin").value,
        contrasena: document.getElementById("passLogin").value
    };

    try {
        const response = await fetch('http://localhost:8080/api/usuarios/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(datosLogin)
        });

        if (response.ok) {
            const respuesta = await response.json();
            alert("¡Bienvenido a Libruarys, " + respuesta.nombre + "!");
            
            // Guardar info opcional
            localStorage.setItem("nombreUsuario", respuesta.nombre);
            localStorage.setItem("rol", respuesta.rol);
            
            // Guardar el idCliente (si existe) en sessionStorage
            if (respuesta.idCliente) {
                sessionStorage.setItem("idCliente", respuesta.idCliente);
            }

            // Redirige según lo que indique el backend
            window.location.href = respuesta.redirect; 
        } else {
            const errorData = await response.json();
            alert(errorData.error || "Correo o contraseña incorrectos.");
        }
    } catch (error) {
        console.error("Error:", error);
        alert("Error al conectar con el servidor.");
    }
}