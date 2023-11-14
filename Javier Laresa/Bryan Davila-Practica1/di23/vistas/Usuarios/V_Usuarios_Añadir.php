
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Añadir Usuario</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Incluye la biblioteca de Bootstrap -->

    <!-- Puedes incluir tu archivo de estilos personalizado aquí si es necesario -->
</head>
<body id="body_formulario">

<div class="container mt-5" >


    <form id="formulario_añadir" action="procesar_formulario.php" method="post">
            <?php
            
            include("controladores/controlador_registro.php")
            ?>

        <div class="form-group">
            <label for="nombre">Nombre:</label>
            <input type="text" class="form-control" name="nombre" >
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="apellido1">Apellido 1:</label>
                <input type="text" class="form-control" name="apellido1" >
            </div>

            <div class="form-group col-md-6">
                <label for="apellido2">Apellido 2:</label>
                <input type="text" class="form-control" name="apellido2" >
            </div>
        </div>

        <div class="form-group">
            <label for="usuario">Usuario:</label>
            <input type="text" class="form-control" name="usuario" >
        </div>

        <div class="form-group">
            <label for="sexo">Sexo:</label>
            <select class="form-control" name="sexo" >
                <option value="H">Hombre</option>
                <option value="M">Mujer</option>
            </select>
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" name="email" >
        </div>

        <div class="form-group">
            <label for="contrasena">Contraseña:</label>
            <input type="password" class="form-control" name="contrasena" >
        </div>

        <div class="form-group">
            <label for="telefono">Teléfono:</label>
            <input type="tel" class="form-control" name="telefono">
        </div>

        <div class="form-group">
            <label for="actividad">Actividad:</label>
            <select class="form-control" name="actividad" >
                <option value="S">Activo</option>
                <option value="N">Inactivo</option>
            </select>
        </div>

        <button type="submit" class="btn btn-primary" id="boton_agregar" name="registro">Añadir Usuario</button>
    </form>
</div>

<!-- Incluye la biblioteca de Bootstrap y jQuery al final del body para un rendimiento óptimo -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.8/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
