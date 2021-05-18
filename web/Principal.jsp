<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.1.0/css/font-awesome.min.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-dark bg-secondary">
            <a style="color: white" class="navbar-toggler"><span class="navbar-toggler-icon"></span>  Practica Emergentes Dao</a>
            <div class="dropdown">
                <a style="color: white" href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Cerrar Session</a>
                <div class="dropdown-menu text-center">
                    <a><img src="img/user.png" height="60" width="60"/></a><br>
                    <a>${usuario}</a>
                    <a>jobe@gmail.com</a>
                    <div class="dropdown-divider"></div>
                    <a href="Controlador?accion=Salir" class="dropdown-item">Salir</a>
                </div>
            </div>
        </nav>
        <div class="container mt-4">
            <h1 class="text-center">Blog de Salud</h1>
        <a class="btn btn-info btn-sm text-white">Nueva Entrada</a>
        <div>
            <p></p>
            <hr>
        <c:forEach var="item" items="${blog}">
        <div class="well">
            <div class="media">
                <div class="media-body">
                    <h4>${item.id}</h4>
                    <h4 class="media-heading">${item.titulo}</h4>
                        <p class="text-right">By Francisco</p>
                        <p>${item.contenido}</p>
         <ul class="list-inline list-unstyled">
            <li><span><i class="fa fa-calendar"></i>${item.fecha}</span>
                <a href="Inicio?action=edit&id=${item.id}">Editar</a>
                <a href="Inicio?action=delete&id=${item.id}">Eliminar</a>
            </li>
            <li>
              <span><i class="fa fa-facebook-square"></i></span>
              <span><i class="fa fa-twitter-square"></i></span>
              <span><i class="fa fa-google-plus-square"></i></span>
            </li>
	</ul>
       </div>
    </div>
  </div>
            <hr>
        </c:forEach>
        </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
