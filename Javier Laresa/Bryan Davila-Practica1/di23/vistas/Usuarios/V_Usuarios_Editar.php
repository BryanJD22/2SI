<?php
    //Hacemos una comprobacion para saber si el usuario ha iniciado sesion y en caso de que haya iniciado le mosntramos el siguiente mensaje

    $usuario = $datos['usuarios'];
?>


<!DOCTYPE html>
<html lang="es">
<html>
    <head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+WyJ8EQxFmRwOOj4BAaK86b1LZz97N6UwEy" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-e8qD9NRlAqw8C2an8lNdG8kHAWFDTyZtldz9n0aPnBcA6IeKKD5bqr25b9stHEi6" crossorigin="anonymous"></script>
        <meta name="viewport" 
            content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" 
            href="librerias/bootstrap-5.1.3-dist/css/bootstrap.min.css">
        </link>
        <link rel="icon" type="image/x-icon" href="img/minilogo.png">
        <script src="js/Usuarios.js"></script>
        <link rel="stylesheet" href="css/index3.css">
        <title>FrutiZ</title>

    </head>
    <body>
    <div id="contenedorEdicionUsuario">
        <form id="formularioEdicionUsuario">
            <input type="hidden" name="id_Usuario" value="<?php echo $usuario[0]['id_Usuario'] ?>">
            Nombre: <input type="text" name="nombre" value="<?php echo $usuario[0]['nombre'] ?>"><br>
            Apellido 1: <input type="text" name="apellido1" value="<?php echo $usuario[0]['apellido_1']?>"><br>
            Apellido 2: <input type="text" name="apellido2" value="<?php echo $usuario[0]['apellido_2'] ?>"><br>    
            <label for="sexo">Sexo:
                <select id="sexo" name="sexo">
                    <option value="M" selected="selected">M</option>
                    <option value="H">H</option>
                </select>
            </label>
            Mail: <input type="text" name="mail" value="<?php echo $usuario[0]['mail'] ?>" ><br>
            Movil: <input type="text" name="movil" value="<?php echo $usuario[0]['movil'] ?>" ><br>
            Login: <input type="text" name="login" value="<?php echo $usuario[0]['login'] ?>" ><br>
            Contraseña: <input type="password" name="pass" value="<?php echo $usuario[0]['pass'] ?>"><br>
            Activo: <input type="text" name="activo" value="<?php echo $activo; ?>"><br>

           <button type="button" onclick="guardarCambios()">Guardar cambios</button>
        </form>
    </div>
    </body>


</html>