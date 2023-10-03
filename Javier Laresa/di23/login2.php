<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            function validar(){
                const usuario= document.getElementById("usuario");
                const pass= document.getElementById("pass");
                let mensaje='';
                if(usuario.value=='' || pass.value==''){
                    mensaje='Desbes completar los campos';
                }else{
                    let opciones={method: "GET"};
                    let parametros= "usuario="+usuario+"&pass="+pass;
                    fetch("validarUsuario.php?"+parametros, opciones)
                        .then(res => {
                            if(res.ok){
                                console.log('respuesta ok');
                                return res.json();
                            }
                        })
                        .then()
                        .catch();




                }
                document.getElementById("msj").innerHTML=mensaje;
            }
        </script>

    </head>
    <body>
    <form id="formularioLogin" name="formularioLogin" method="post" action="login.php">
        <label for="usuario">Usuario:</label><br>
            <input type="text" id="usuario" name="usuario" 
                value=""><br>

        <label for="pass">Contraseña:</label><br>   
            <input type="password" id="pass" name="pass" 
                value=""><br>
        <span id="msj"></span>
            <button type="button" id="aceptar" onclick="validar()">Aceptar</button>
    </form>

    </body>
</html>