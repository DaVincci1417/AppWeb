<%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 6/20/2023
  Time: 11:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="estilos.css">
  <title>Registro usuario</title>
</head>
<body>
<h1 class="encabezado"> Registro usuario </h1>
<h2 class="subtitulo"> Ya existe un usuario con ese RUT</h2>
<form action="registroUsuario" method="post">
  <div class="centrado">
    <label> Nombre: </label>
    <input name="nombre" type="text" class="campoTexto">
    <label> RUT: </label>
    <input name="rut" type="text" class="campoTexto">
    <label> Edad: </label>
    <input name="edad" type="number" class="campoTexto">
    <br><br>
    <input type="submit" value="enviar" class="boton">
  </div>
</form>
</body>
</html>
