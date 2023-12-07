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


function agregarUsuario() {
    let opciones = { method: "POST" };
    
    let parametros = "controlador=Usuarios&metodo=crearUsuario";
    
    parametros += "&" + new URLSearchParams(new FormData(document.getElementById("formulario_crear"))).toString();

    console.log(parametros);

    fetch("C_Ajax.php?" + parametros, opciones)
        .then(res => {
            if (res.ok) {

                console.log('Usuario agregado correctamente');
                return res.text();
                
            }
        })
        .catch(err => {
            console.log("Error al realizar la petición.", err.message);
        });

}

function getVistaEditar(idUsuario) {
    let opciones = { method: "GET" };
    

    // Construye la URL de la petición AJAX
    let url = 'http://localhost/C_Ajax.php?controlador=Usuarios&metodo=getVistaEditar&id_Usuario=' + idUsuario;

    console.log(url);

    // Realiza la petición AJAX
    fetch(url, opciones)
        .then(response => {
            if(response.ok){
                console.log('respuesta ok');
                return response.text();
            }

        })
        .then(data => {

            document.getElementById("contenedorEdicionUsuario").innerHTML = data;
            
        })
        .catch(error => console.error('Error:', error));
}

function getParams(id){
    console.log(id);
    let opciones = { method: "GET" };
    let parametros = "controlador=Usuarios&metodo=buscarUsuarioPorID";
    parametros += "&id_Usuario="+id;

    fetch("C_Ajax.php?" + parametros, opciones)
        .then(res => {
            if (res.ok) {
                console.log('respuesta ok');
                return res.text();
            }
        })
        .then(vista => {
            document.getElementById("capaResultadosBusqueda").innerHTML = vista;
        })
        .catch(err => {
            console.log("Error al realizar la petición", err.message);
        });
}
