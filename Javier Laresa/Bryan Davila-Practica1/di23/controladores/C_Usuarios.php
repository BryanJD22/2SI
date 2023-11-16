<?php
    require_once 'controladores/Controlador.php';
    require_once 'vistas/Vista.php';
    require_once 'modelos/M_Usuarios.php';

    class C_Usuarios extends Controlador{
        private $modelo;
        public function __construct(){
            parent::__construct();
            $this->modelo = new M_Usuarios();
        }

        public function validarUsuario($filtros){
            $valido='N';
            $usuario=$this->modelo->buscarUsuarios($filtros);
            if (!empty($usuario)) {
                $valido='S';
                $_SESSION['usuario'] = $usuario[0]['login'];
            }
            return $valido;
        }

        public function getVistaUsuarios(){
            Vista::render('vistas/Usuarios/V_Usuarios.php');
        }

        public function getVistaAñadir(){
            Vista::render('vistas/Usuarios/V_Usuarios_Añadir.php');
        }

        public function buscarUsuarios($filtros=array()){
            $usuarios=$this->modelo->buscarUsuarios($filtros);
            //echo json_encode($usuarios);
            Vista::render('vistas/Usuarios/V_Usuarios_Listado.php', 
                            array('usuarios'=>$usuarios));
        }

        public function AñadirUsuario($filtros = array()) {
            if ($_SERVER['REQUEST_METHOD'] === 'POST') {
                // Procesar el formulario y añadir el usuario a la base de datos
                $nombre = $_POST['nombre'];
                $apellido1 = $_POST['apellido1'];
                $apellido2 = $_POST['apellido2'];
                $usuario = $_POST['usuario'];
                $sexo = $_POST['sexo'];
                $email = $_POST['email'];
                $contrasena = $_POST['contrasena'];
                $telefono = $_POST['telefono'];
                $actividad = $_POST['actividad'];

                $filtros = array(
                    'nombre' => $nombre,
                    'apellido_1' => $apellido1,
                    'apellido_2' => $apellido2,
                    'usuario' => $usuario,
                    'sexo' => $sexo,
                    'email' => $email,
                    'contrasena' => $contrasena,
                    'telefono' => $telefono,
                    'actividad' => $actividad
                );
        
                // Aquí deberías validar y sanitizar los datos antes de usarlos en la consulta SQL
        
                $this->modelo->añadirUsuario($filtros);
                
            } else {
                // Mostrar el formulario de añadir usuario
                Vista::render('vistas/Usuarios/V_Usuarios_Añadir.php');
            }
        }
        
        


    }
?>