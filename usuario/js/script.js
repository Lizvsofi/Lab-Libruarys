function toggleMenu() {
const menu = document.getElementById("navLinks");
menu.classList.toggle("active");
}

function toggleDropdown(event) {
event.preventDefault();
document.getElementById("submenu").classList.toggle("show");
}

document.addEventListener("DOMContentLoaded", () => {

/* animación de tarjetas */

const cards = document.querySelectorAll(".card");

cards.forEach((card, index) => {

card.style.opacity="0";
card.style.transform="translateY(20px)";

setTimeout(()=>{
card.style.transition="all .5s";
card.style.opacity="1";
card.style.transform="translateY(0)";
},index*200);

});


/* compras */

let carrito = JSON.parse(localStorage.getItem("carrito")) || [];

const contador = document.getElementById("contador-carrito");
const mensaje = document.getElementById("mensaje-carrito");

contador.textContent = carrito.length;

const botones = document.querySelectorAll(".agregar");

botones.forEach((boton)=>{

boton.addEventListener("click",()=>{

const tarjeta = boton.closest(".tarjeta-libro");

const libro = {
titulo: tarjeta.querySelector("h3").textContent,
precio: tarjeta.querySelector(".precio").textContent,
imagen: tarjeta.querySelector("img").src
};

carrito.push(libro);

localStorage.setItem("carrito",JSON.stringify(carrito));

contador.textContent = carrito.length;
mensaje.classList.add("mostrar");

setTimeout(()=>{
mensaje.classList.remove("mostrar");
},2000);

});

});

});
document.addEventListener("DOMContentLoaded",()=>{

const contenedor = document.getElementById("lista-carrito");

let carrito = JSON.parse(localStorage.getItem("carrito")) || [];

let totalPrecio = 0;

carrito.forEach((libro,index)=>{

const item = document.createElement("div");

item.classList.add("item-carrito");

item.innerHTML=`

<div style="display:flex;align-items:center;gap:20px;">

<div>${index+1}</div>

<img src="${libro.imagen}" width="60">

<div>
<b>${libro.titulo}</b>
<br>
${libro.precio}
</div>

</div>

<button class="quitar" data-index="${index}" 
style="background:#b8860B;color:white;border:none;padding:8px 15px;border-radius:5px;">
Quitar
</button>

`;

contenedor.appendChild(item);

/* calcular precio */

let precio = parseFloat(libro.precio.replace("$",""));
totalPrecio += precio;

});

/* totales */

document.getElementById("total-libros").textContent = carrito.length;
document.getElementById("total-precio").textContent = totalPrecio;


/* quitar libro */

document.querySelectorAll(".quitar").forEach(btn=>{

btn.addEventListener("click",()=>{

let index = btn.dataset.index;

carrito.splice(index,1);

localStorage.setItem("carrito",JSON.stringify(carrito));

location.reload();

});

});

});