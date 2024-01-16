<?php
echo '<div id="bloqueTxt"><a id="txtBusqueda">Busqueda de Usuarios</a></div>';

    

?>
<form id="formularioBuscar" name="formularioBuscar" onkeydown="return event.key != 'Enter';">
<label for="b_texto">
    <input type="text" id="b_texto" name="b_texto" placeholder="Nombre">
</label>
<label for="c_texto">Sexo
   <select  class="form-control" id="form_sexo"  name="c_texto">
   <option value="T">Todos</option>
    <option value="H">H</option>
    <option value="M">M</option>
   </select>
</label>
<label  for="d_texto">Actividad
    <input type="checkbox" id="d_texto" name="d_texto" value="S" >
</label>
<button type="button" class="btn btn-success"  id="btnBuscar" onclick="buscarUsuarios()">Buscar</button>

<button type="button" class="btn btn-success" id="btnAñadir" onclick="getVistaMenuSeleccionado('Usuarios', 'getVistaAñadir')">Añadir</button>



</form>
<div id="capaResultadosBusqueda">
</div>