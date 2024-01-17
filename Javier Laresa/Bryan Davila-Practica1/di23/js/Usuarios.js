function buscarUsuarios(pagina){
    let opciones = { method: "GET" };
    let parametros = "controlador=Usuarios&metodo=buscarUsuarios";
    parametros += "&" + new URLSearchParams(new FormData(document.getElementById("formularioBuscar"))).toString();


        //EXTRA PARA HACER UN PAGINADOR 
        var numPagina = document.querySelector('#num-pagina');
        if(pagina === undefined){
            console.log("pagina: undefined");
            if(numPagina != null){
                //alert("pagina: "+numPagina.value);
                let num = document.querySelector('#num-pagina').value - 1;
                parametros += "&" + "pagina="+num;
            }
            //alert(parametros);
        }else if(pagina === "siguiente"){
            console.log("pagina: "+pagina);
            if(numPagina != null){
                //alert("pagina: "+numPagina.value);
                let num = document.querySelector('#num-pagina').value;
                parametros += "&" + "pagina="+num;
            }
            //alert(parametros);
        }else if(pagina === "anterior"){
            console.log("pagina: "+pagina);
            if(numPagina != null){
                //alert("pagina: "+numPagina.value);
                let num = document.querySelector('#num-pagina').value - 2;
                parametros += "&" + "pagina="+num;
            }
            //alert(parametros);
        }else{
            console.log("pagina: "+pagina);
            if(numPagina != null){
                pagina = pagina - 1;
                //alert("pagina: "+numPagina.value);
                parametros += "&" + "pagina="+pagina;
            }
            //alert(parametros);
        }
        //EXTRA PARA HACER UN PAGINADOR 
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

function guardarCambios(id){
    let opciones = { method: "GET" };
    let parametros = "controlador=Usuarios&metodo=editarUsuarios";
    parametros += "&id_Usuario=" + id + "&" + new URLSearchParams(new FormData(document.getElementById("formularioEdicionUsuario"))).toString();

    console.log(parametros)

    fetch("C_Ajax.php?" + parametros, opciones)
        .then(res => {
            if (res.ok) {
                console.log('respuesta ok');
                return res.text();
            }
        })
        .then(vista => {
            document.getElementById("capaResultadosUpdatear").innerHTML = vista;
        })
        .catch(err => {
            //Error al realizar la petición Cannot set properties of null (setting 'innerHTML')
            console.log("Error al realizar la petición", err.message);
        });
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
