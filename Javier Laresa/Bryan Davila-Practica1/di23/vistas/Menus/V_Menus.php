<?php

    $menus = $datos['menus'];
?>


<?php
echo '<section id="secMenuPagina" class="container-fluid">';
echo '<nav class="navbar navbar-expand-sm navbar-light" id="cabeceraApartados" aria-label="Fourth navbar example">';
echo '<div class="container-fluid">';
echo '<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">';
echo '<span class="navbar-toggler-icon"></span>';
echo '</button>';
echo '<div class="collapse navbar-collapse" id="navbarsExample04">';
echo '<ul class="navbar-nav me-auto mb-2 mb-md-0">';
foreach ($menus as $menus){
    if($menus['id_menu_padre']==null){
        echo '<li class="nav-item">';
        echo '<a class="nav-link active" aria-current="page" href="index.php">'. $menus['titulo'] .'</a>';
        echo '</li>';

    }else if($menus ['id_menu_padre'!=null]){

        

    }
}

echo '<li class="nav-item">';
echo '<a class="nav-link active" aria-current="page" href="index.php">Home</a>';
echo '</li>';
echo '<li class="nav-item">';
echo '<a class="nav-link" href="#">Link</a>';
echo '</li>';
echo '<li class="nav-item">';
echo '<a class="nav-link disabled">Disabled</a>';
echo '</li>';
echo '<li class="nav-item dropdown">';
echo '<a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown" aria-expanded="false">Cruds</a>';
echo '<ul class="dropdown-menu">';
echo '<li><a class="dropdown-item" onclick="getVistaMenuSeleccionado(\'Usuarios\', \'getVistaUsuarios\')">Usuarios</a></li>';
echo '<li><a class="dropdown-item" onclick="getVistaMenuSeleccionado(\'\', \'\')">Something else here</a></li>';
echo '<li><a class="dropdown-item" onclick="getVistaMenuSeleccionado(\'\', \'\')">Something else here</a></li>';
echo '</ul>';
echo '</li>';
echo '</ul>';
echo '</div>';
echo '</div>';
echo '</nav>';
echo '</section>';
?>
