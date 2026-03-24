function toggleMenu() {
const menu = document.getElementById("navLinks");
menu.classList.toggle("active");
}

function toggleDropdown(event) {
event.preventDefault();
document.getElementById("submenu").classList.toggle("show");
}

document.addEventListener("DOMContentLoaded", () => {
    let carrito = JSON.parse(localStorage.getItem("carrito")) || [];
    const contador = document.getElementById("contador-carrito");
    const botones = document.querySelectorAll(".agregar");

    botones.forEach((boton) => {
        boton.addEventListener("click", () => {
            const tarjeta = boton.closest(".tarjeta-libro");
            
            // EXTRAEMOS EL ID DEL ATRIBUTO data-id DEL HTML
            const idLibro = tarjeta.getAttribute("data-id");

            if (!idLibro) {
                console.error("Error: La tarjeta no tiene data-id");
                return;
            }

            const libro = {
                id: parseInt(idLibro), 
                titulo: tarjeta.querySelector("h3").textContent,
                precio: tarjeta.querySelector(".precio").textContent.replace("$", ""),
                imagen: tarjeta.querySelector("img").src,
                cantidad: 1
            };

            carrito.push(libro);
            localStorage.setItem("carrito", JSON.stringify(carrito));
            if(contador) contador.textContent = carrito.length;

            alert("Libro añadido al carrito");
        });
    });
});


/* compras */

let carrito = JSON.parse(localStorage.getItem("carrito")) || [];

const contador = document.getElementById("contador-carrito");
const mensaje = document.getElementById("mensaje-carrito");

if(contador){
  contador.textContent = carrito.length;
}

const botones = document.querySelectorAll(".agregar");
console.log("botones:", botones.length);

botones.forEach((boton)=>{

boton.addEventListener("click",()=>{

const tarjeta = boton.closest(".tarjeta-libro");
const libro = {
    id: parseInt(tarjeta.getAttribute("data-id")), // <-- ESTO ES VITAL
    titulo: tarjeta.querySelector("h3").textContent,
    precio: tarjeta.querySelector(".precio").textContent,
    imagen: tarjeta.querySelector("img").src,
    cantidad: 1
};

carrito.push(libro);

localStorage.setItem("carrito",JSON.stringify(carrito));

contador.textContent = carrito.length;
if(mensaje){
  mensaje.classList.add("mostrar");

  setTimeout(()=>{
    mensaje.classList.remove("mostrar");
  },2000);
}

setTimeout(()=>{
mensaje.classList.remove("mostrar");
},2000);

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