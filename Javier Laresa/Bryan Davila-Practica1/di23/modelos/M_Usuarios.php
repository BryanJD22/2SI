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

    public function añadirUsuario($filtros = array()) {
        $nombre='';
        $apellido1='';
        $apellido2='';
        $usuario='';
        $sexo='';
        $email='';
        $contrasena='';
        $telefono='';
        $actividad='';

        extract($filtros);
    
        // Construir la consulta SQL utilizando consultas preparadas para evitar inyecciones SQL
        $SQL = "INSERT INTO usuarios (`nombre`, `apellido_1`, `apellido_2`, `sexo`, `activo`, `login`, `pass`, `email`)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
        // Preparar la consulta
        $stmt = $this->DAO->conexion->prepare($SQL);
    
        if ($stmt) {
            // Asociar parámetros y ejecutar la consulta
            $stmt->bind_param("ssssssss", $nombre, $apellido_1, $apellido_2, $sexo, $actividad, $email, $hashedPassword, $email);
            $stmt->execute();
    
            // Verificar si la inserción fue exitosa
            if ($stmt->affected_rows > 0) {
                echo "Usuario agregado correctamente";
            } else {
                echo "Error al agregar el usuario";
            }
    
            // Cerrar la consulta preparada
            $stmt->close();
        } else {
            echo "Error al preparar la consulta";
        }
    }
    



}
