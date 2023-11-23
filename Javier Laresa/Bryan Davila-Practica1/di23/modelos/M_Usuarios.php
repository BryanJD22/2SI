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

    public function buscarUsuarios($filtros = array()){
        $d_texto='';
        $c_texto='';
        $b_texto = '';
        $usuario = '';
        $pass = '';
        extract($filtros);

        $SQL = "SELECT * FROM usuarios WHERE 1=1";

        if ($usuario != '' && $pass != '') {
            $usuario = addslashes($usuario);
            $pass = addslashes($pass);
            $SQL .= " AND login = '$usuario' AND pass = MD5('$pass')";
        }else{
            if ($b_texto != '') {
                $aTexto = explode(' ', $b_texto);
                $SQL .= " AND (1=2 ";
                foreach ($aTexto as $palabra) {
                    $SQL .= " OR apellido_1 LIKE '%$palabra%' ";
                    $SQL .= " OR apellido_2 LIKE '%$palabra%' ";
                    $SQL .= " OR nombre LIKE '%$palabra%' ";
                }
                $SQL .= " ) ";
            }
            //  echo $c_texto;
            if ( $c_texto !='T') {
    
                $SQL .= " AND sexo = '$c_texto'";
            }
            // echo $d_texto;
            // var_dump ($filtros);
            if ($d_texto != '') {
    
                $SQL .= " AND activo = '$d_texto'";
            }
        }
        


        // echo $SQL;
        $usuarios = $this->DAO->consultar($SQL);
        return $usuarios;
    }


    // public function buscarUsuariosMayores($filtros=array()){
    //     $c_texto='';
    //     $usuario='';
    //     $pass='';
    //     extract($filtros);

    //     $SQL = "SELECT * FROM usuarios WHERE sexo = 'H'";


    //     if ($usuario!='' && $pass!='') {
    //         $usuario = addslashes($usuario);
    //         $pass = addslashes($pass);
    //         $SQL.=" AND login = '$usuario' AND pass = MD5('$pass')";
    //     }
    //     if($c_texto!=''){
    //         $dTexto=explode(' ', $c_texto);
    //         $SQL.=" AND sexo = '$c_texto'";
    //     }
    //     // echo $SQL;
    //     $usuarios=$this->DAO->consultar($SQL);
    //     return $usuarios;
    // }

    public function crearUsuario($filtros = array()) {
        $nombreEdt='';
        $apellido1Edt='';
        $apellido2Edt='';
        $loginEdt='';
        $sexoEdt='';
        $emailEdt='';
        $passEdt='';
        $movilEdt='';
        $actividadEdt='';

        echo("1");
        extract($filtros);
        echo(extract($filtros));
        // Construir la consulta SQL utilizando consultas preparadas para evitar inyecciones SQL
        $SQL = "INSERT INTO usuarios (`nombre`, `apellido_1`, `apellido_2`, `sexo`, 'fecha_Alta', `mail`, `movil`, `login`, `pass`, `activo`)
        VALUES ('$nombreEdt', '$apellido1Edt', '$apellido2Edt', '$sexoEdt', NOW(), '$emailEdt', '$movilEdt', '$loginEdt', 'MD5($passEdt)', '$actividadEdt')";


        echo($SQL);
        
        $usuarios = $this->DAO->insertar($SQL);

    }

    
    



    
    public function xUsuario($parametros =  array())
    {
        $apellido_insert = '';
        $nombre_insert = '';
        $usuario_insert = '';
        $sexo_insert = '';
        $telefono_insert = '';
        $password_insert = '';


        extract($parametros);
        $SQL = "INSERT INTO usuarios (nombre, apellido_1, apellido_2, sexo, fecha_Alta, mail,movil, login, pass, activo )";


        $nombre_insert = addslashes($nombre_insert);
        $apellido_insert = addslashes($apellido_insert);
        $usuario_insert = addslashes($usuario_insert);
        $telefono_insert = addslashes($telefono_insert);
        $sexo_insert = addslashes($sexo_insert);
        $password_insert = addslashes($password_insert);

        $SQL .= "VALUES('$nombre_insert','$apellido_insert','$apellido_insert','$sexo_insert',NOW(),'$usuario_insert@correoPrueba.com','$telefono_insert','$usuario_insert',MD5('$password_insert'),'S')";




        $this->DAO->insertar($SQL);

        $mensaje = 'Usuario introducido correctamente';


        return $mensaje;

    }


}
