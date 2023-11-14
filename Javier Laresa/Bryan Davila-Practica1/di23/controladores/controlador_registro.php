<?php
    if (!empty($_POST["registro"])) {
        if (empty($_POST["nombre"]) or empty($_POST["apellido1"]) or empty($_POST["apellido2"]) or empty($_POST["usuario"]) or empty($_POST["sexo"]) or empty($_POST["email"]) or empty($_POST["contraseña"]) or empty($_POST["actividad"]) ) {
            echo 'Uno de los campos está vacío';

        }
    }



?>