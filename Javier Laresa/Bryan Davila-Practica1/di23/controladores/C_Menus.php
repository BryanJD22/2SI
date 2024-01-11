<?php

    require_once 'controladores/Controlador.php';
    require_once 'vistas/Vista.php';
    require_once 'modelos/M_Menus.php';

    class C_Menus extends Controlador{
        private $modelo;
        public function __construct(){
            parent::__construct();
            $this->modelo = new M_Menus();

        }

        public function getMenus(){ 
            $menus=$this->modelo->buscarmenus();
            echo json_encode($menus);
            Vista::render('vistas/Menus/Menus.php', 
                            array('menus'=>$menus));
        }


    }
?>