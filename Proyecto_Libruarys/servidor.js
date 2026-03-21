const express = require('express');
const mysql = require('mysql2');
const cors = require('cors');
const app = express();

app.use(cors());
app.use(express.json());

// 1. Configuración de la conexión a MySQL
const db = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: 'root', // Tu contraseña de MySQL Workbench
    database: 'mydb'  // El nombre de tu base de datos
});

// 2. Conectar a la base de datos
db.connect(err => {
    if (err) {
        console.error('Error conectando a MySQL:', err.message);
        return;
    }
    console.log('¡Conexión exitosa a la base de datos!');
});


// 3. Ruta para obtener los LIBROS (como vi en tu última captura)
app.get('/libros', (req, res) => {
    const query = 'SELECT * FROM libros';
    db.query(query, (err, results) => {
        if (err) {
            return res.status(500).send('Error al consultar la base de datos');
        }
        res.json(results);
    });
});

// 4. Iniciar el servidor
app.listen(3000, () => {
    console.log('Servidor corriendo en el puerto 3000');
});