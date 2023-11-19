const menuburger = document.getElementById("menuburger");
const header = document.getElementById("header");

menuburger.addEventListener("click", () => {
    header.classList.toggle("header--open");
});


/*Galeria*/
var fullImgBox = document.getElementById("fullImgBox");
var fullImg = document.getElementById("fullImg");

function openFullImg(pic){
    fullImgBox.style.display = "flex";
    fullImg.src = pic;
} 

function closeFullImg(){
    fullImgBox.style.display = "none";

}

document.querySelector(".textmenu").addEventListener("click", function () {
  const usernameElement = document.getElementById("usernameElement");
  const allowedEmails = ["admin1@svalero.com", "admin2@svalero.com", "admin3@svalero.com"];

  if (allowedEmails.includes(usernameElement.value)) {
    // Redirigir a la página inicio.html
    window.location.href = "inicio.html";
  } else {
    // Aquí colocas el código que se ejecutará cuando el correo no sea uno de los permitidos
    console.log("Correo inválido. Acción del botón no permitida.");
  }
});
