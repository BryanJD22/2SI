<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>LoginPHP</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>

    <script type="text/javascript">
        function validar(){
            const usuario = document.getElementById("usuario");
            const pass = document.getElementById("pass");

            if (usuario.value==''|| pass.value=='') {
                
            } else {
                
            }
        }
    </script>
</head>
<body>
    

    <form id="formulariologin" method="post" action="">
        <label for="usuario">Usuario:</label></br>
            <input type="text" id="usuario" name="usuario" value=""></br>

        <label for="pass">Contraseña:</label></br>
            <input type="pass" id="pass" name="pass" value=""></br>
        
    <button type="button" id="aceptar" onclick="validar()" >Aceptar</button>
    </form> 

</body>
</html>