async function validarLogin(event) {
    event.preventDefault();

    const datosLogin = {
        correo: document.getElementById("correo").value,
        contrasena: document.getElementById("pass1").value 
    };

    try {
        const response = await fetch('http://localhost:8080/api/usuarios/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(datosLogin)
        });

        if (response.ok) {
            const respuesta = await response.json(); // Recibe el mapa con "redirect" y "nombre"
            alert("¡Bienvenido, " + respuesta.nombre + "!");
            
            // Guardamos info para usarla después
            localStorage.setItem("nombreUsuario", respuesta.nombre);
            localStorage.setItem("rol", respuesta.rol);

            // CLAVE: Aquí usamos la ruta que manda el servidor (Java)
            window.location.href = respuesta.redirect; 
        } else {
            alert("Correo o contraseña incorrectos.");
        }
    } catch (error) {
        console.error("Error:", error);
        alert("Error al conectar con el servidor.");
    }
}

async function validarLogin(event) {
    event.preventDefault();

    const datosLogin = {
        correo: document.getElementById("correo").value,
        contrasena: document.getElementById("pass1").value // Asegúrate que el ID coincida con tu HTML
    };

    try {
        const response = await fetch('http://localhost:8080/api/usuarios/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(datosLogin)
        });

        if (response.ok) {
            const respuesta = await response.json();
            alert("¡Bienvenido, " + respuesta.nombre + "!");
            
            // Guardamos info útil en el navegador
            localStorage.setItem("nombreUsuario", respuesta.nombre);
            localStorage.setItem("rol", respuesta.rol);

            // Redirección automática según lo que decidió el servidor
            window.location.href = respuesta.redirect; 
        } else {
            alert("Correo o contraseña incorrectos. Intenta de nuevo.");
        }
    } catch (error) {
        console.error("Error:", error);
        alert("Hubo un problema al conectar con el servidor.");
    }
}