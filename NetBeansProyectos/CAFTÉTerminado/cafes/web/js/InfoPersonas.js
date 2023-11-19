

var personas = [
    {
        imagen: "img/ALEX.jpg",
        nombre: "Alejandro",        nombres: "Alejandro",

        apellidos: "Cerqueira Navarro",
        nacimiento: "24/09/2003",
        correo: "admin1@svalero.com",
        identificador: "1928",
        puesto: "Secretary"
    },
    {
        imagen: "img/IsraelColta.png",
        nombre: "Israel",        nombres: "Israel",

        apellidos: "Colta Bujalance",
        nacimiento: "24/09/2003",
        correo: "admin2@svalero.com",
        identificador: "2736",
        puesto: "Chairman"
    },
    {
        imagen: "img/Bryan.jpg",
        nombre: "Bryan",
                nombres: "Bryan",

        apellidos: "Dávila Cianca",
        nacimiento: "24/09/2003",
        correo: "admin3@svalero.com",
        identificador: "5311",
        puesto: "Syndicate"

    }
];
var namesInput = document.getElementById("name1");
var nameInput = document.getElementById("name");
var surnameInput = document.getElementById("surname");
var dateInput = document.getElementById("date");
var jobInput = document.getElementById("job");
var idInput = document.getElementById("id");
var imagenPersona = document.getElementById("profile-image");


if (sessionStorage.getItem('username') === "admin1@svalero.com" || "admin2@svalero.com" || "admin3@svalero.com") {

    var informacionAlejandro = personas.find(function (persona) {
        return persona.correo === sessionStorage.getItem('username');
    });

    // Mostrar la información en los campos de texto
    if (informacionAlejandro) {
        namesInput.value= informacionAlejandro.nombres;
        nameInput.value = informacionAlejandro.nombre;
        surnameInput.value = informacionAlejandro.apellidos;
        dateInput.value = informacionAlejandro.nacimiento;
        jobInput.value = informacionAlejandro.puesto;
        idInput.value = informacionAlejandro.identificador;
        imagenPersona.src = informacionAlejandro.imagen;

    } else {
        console.log("No se encontró información para el usuario.");
    }
}
