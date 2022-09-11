<%-- 
    Document   : Principal
    Created on : 31/08/2022, 11:43:55 AM
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
      
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/Principal.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Principal</title>
    </head>
    <body class="body">
        <nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark" style="background: #023E7D;">
            <a class="navbar-brand" href="#"><img src="img/Logo blanco.png" width="100px"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a style="color: #ffffff" class="nav-link" href="Home.jsp" target="myFrame">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a style="color: #ffffff" class="nav-link" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
                    </li>
                    <li class="nav-item">
                        <a style="color: #ffffff" class="nav-link" href="Controlador?menu=Cliente&accion=Listar" target="myFrame">Cliente</a>
                    </li>
                    <li class="nav-item">
                        <a style="color: #ffffff" class="nav-link" href="Controlador?menu=Pedidos&accion=listar" target="myFrame">Pedidos</a>
                    </li>
                    <li class="nav-item">
                        <a style="color: #ffffff" class="nav-link" href="Controlador?menu=Producto&accion=Listar" target="myFrame">Producto</a>
                    </li>
                    <li class="nav-item">
                        <a style="color: #ffffff" class="nav-link" href="Controlador?menu=Proveedor&accion=Listar" target="myFrame">Proveedor</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a style="color: #ffffff" class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Ver mas
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="Controlador?menu=Garantia&accion=Listar" target="myFrame">Garantia</a>
                    <a class="dropdown-item" href="Controlador?menu=FormaDePago&accion=Listar" target="myFrame">Forma de Pago</a>
                    <a class="dropdown-item" href="Controlador?menu=TelefonoProveedor&accion=listar" target="myFrame">Telefono proveedor</a>
                    <a class="dropdown-item" href="Controlador?menu=detallePedidos&accion=Listar" target="myFrame">Detalle Pedidos</a>
                    <a class="dropdown-item" href="Controlador?menu=Estado&accion=Listar" target="myFrame">Estado Producto</a>
                    <a class="dropdown-item" href="Controlador?menu=Categoria&accion=Listar" target="myFrame">Categoria</a>
                  </div>
                </li>
              </ul>
            </div>
            
            
            <div class="dropdown">
                <button class="btn btn-outline-light dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false" id="dropdownMenuButton" aria-haspopup="true" style="border: none">
                    ${usuario.getNombreEmpleado()} ${usuario.getApellidoEmpleado()}
                </button>
                <div class="dropdown-menu text-center" aria-labellebdy="dropdownMenuButton">
                    <a class="dropdown-item" href="#">
                         <img src="foto/${usuario.getFoto()}" width="60%"/>
                    </a>
                    <a class="dropdown-item" href="#">${usuario.getUsuario()}</a>
                    <a class="dropdown-item" href="#">${usuario.getCorreoEmpleado()}</a>
                    <div class="dropdown-divider"></div>
                    <form action="Validar" method="POST">
                        <button name="accion" name="Salir" class="dropdown-item" href="#">Salir</button>
                    </form>
                </div>
            </div>
            
        </nav>
        <div class="embed-container" style="height: 914px;" id="iFrame">
            <iframe src="Home.jsp" name="myFrame" fr style="height: 100%; width: 100%; border: none;"></iframe>
        </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>   
    </body>
</html>
