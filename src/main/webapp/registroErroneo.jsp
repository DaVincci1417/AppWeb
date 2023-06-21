
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Registro usuario</title>
</head>
<body class="body">
<h1 class="encabezado"> Registro usuario </h1>
<h2 class="subtitulo"> Ha dejado espacios en blanco</h2>
<form action="registroUsuario" method="post" class="form">
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
