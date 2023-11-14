
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Añadir Usuario</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

<form id= "formulario_añadir" action="procesar_formulario.php" method="post">
    <label for="apellido">Apellido:</label>
    <input type="text" name="apellido" required>

    <label for="nombre">Nombre:</label>
    <input type="text" name="nombre" required>

    <label for="usuario">Usuario:</label>
    <input type="text" name="usuario" required>

    <label for="sexo">Sexo:</label>
    <select name="sexo" required>
        <option value="H">Hombre</option>
        <option value="M">Mujer</option>
    </select>

    <label for="telefono">Teléfono:</label>
    <input type="tel" name="telefono">

    <label for="actividad">Actividad:</label>
    <select name="actividad" required>
        <option value="S">Activo</option>
        <option value="N">Inactivo</option>
    </select>

    <button type="submit">Añadir Usuario</button>
</form>

</body>
</html>
