const express = require('express');
const mysql = require('mysql2');
const app = express();

// 1. Configuración de la conexión
const db = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'root', // Contraseña
  database: 'mydb' // Nombre de la base de datos
});

// 2. Conectar a la base de datos
db.connect(err => {
  if (err) {
    console.error('Error conectando a MySQL:', err.message);
    return;
  }
  console.log('¡Conexión exitosa a la base de datos!');
});

// Ruta para obtener todos los libros
app.get('/libros', (req, res) => {
  const query = 'SELECT * FROM libros';
  
  db.query(query, (err, results) => {
    if (err) {
      return res.status(500).send('Error al consultar la base de datos');
    }
    res.json(results); 
  });
});

// 3. Levantar el servidor
app.listen(3000, () => {
  console.log('Servidor corriendo en el puerto 3000');
});