<?php

require_once 'modelos/Modelo.php';
require_once 'modelos/DAO.php';
class M_Usuarios extends Modelo
{
    public $DAO;

    public function __construct()
    {
        parent::__construct(); //ejecuta constructor del padre
        $this->DAO = new DAO();
    }

    public function buscarmenus($filtros = array()){
        $posicion = '';
        $titulo='';
        $id_padre='';
        $accion = '';
        $privado = '';
        extract($filtros);

        $SQL = "SELECT * FROM menus WHERE 1=1";


        // echo $SQL;
        $menus = $this->DAO->consultar($SQL);
        return $menus;
    }


}
