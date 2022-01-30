<?php
    if(isset($_POST["nregistro"])){
        $registro=($_POST["nregistro"]);
        $nombre=($_POST["nombre"]);
        $laboratorio=($_POST["laboratorio"]);
        $activo=($_POST["activo"]);
        $servidor="localhost";
        $usuario="root";
        $password="";
        $dbname="aemps";
        $conexion=mysqli_connect($servidor,$usuario,$password,$dbname);
    if(!$conexion){
        echo"Error en la conexiona MySQL: ".mysqli_connect_error();
        exit();
    }
   
        $sql="INSERT INTO registros (registro, nombre, laboratorio, activo) VALUES ('".$registro."','".$nombre."','".$laboratorio."','".$activo."')";
    if(mysqli_query($conexion,$sql)){
        echo"Registro insertado correctamente.";
    }else{
        echo"Error: ".$sql."<br>".mysqli_error($conexion);
    }
    
    }
?>