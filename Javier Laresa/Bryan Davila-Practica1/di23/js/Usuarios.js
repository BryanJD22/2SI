function buscarUsuarios(){
    let opciones = { method: "GET" };
    let parametros = "controlador=Usuarios&metodo=buscarUsuarios";
    parametros += "&" + new URLSearchParams(new FormData(document.getElementById("formularioBuscar"))).toString();
    fetch("C_Ajax.php?" + parametros, opciones)
        .then(res => {
            if (res.ok) {
                console.log('Respuesta ok');
                return res.text();
            }
        })
        .then(vista => {

            document.getElementById("capaResultadosBusqueda").innerHTML = vista;
        })
        .catch(err => {
            console.log("Error al realizar la peticion.", err.message);
        });
}


function agregarUsuario(event) {

    event.preventDefault();
    
    let opciones = { method: "POST" };
    
    let parametros = "controlador=Usuarios&metodo=AñadirUsuario";
    
    parametros += "&" + new URLSearchParams(new FormData(document.getElementById("formulario_añadir"))).toString();

    console.log(parametros);

    fetch("C_Ajax.php?" + parametros, opciones)
        .then(res => {
            if (res.ok) {
                console.log('Usuario agregado correctamente');
                // Puedes redirigir o realizar alguna acción adicional después de agregar el usuario
            }
        })
        .catch(err => {
            console.log("Error al realizar la petición.", err.message);
        });

}