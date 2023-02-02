<?php
function retornarConexion() {
  $con=mysqli_connect("localhost","root","password","angular_crud");
  return $con;
}
?>