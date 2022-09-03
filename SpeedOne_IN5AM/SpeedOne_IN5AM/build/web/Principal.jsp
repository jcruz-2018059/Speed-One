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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Principal</title>
    </head>
    <body class="body">
        <nav class="navbar navbar-expand-lg" style="background: #023E7D">
            <div class="container-fluid">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a style="border: none; margin-left: 10px " class="btn btn-outline-light" href="#">Home</a>
                    </li>
                    <li class="nav-item active">
                        <a style="border: none; margin-left: 10px " class="btn btn-outline-light" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
                    </li>
                    <li class="nav-item active">
                        <a style="border: none; margin-left: 10px " class="btn btn-outline-light" href="Controlador?menu=Categoria&accion=Listar" target="myFrame">Categoría</a>
                    </li>
                    <li class="nav-item active">
                        <a style="border: none; margin-left: 10px " class="btn btn-outline-light" href="Controlador?menu=Cliente&accion=Listar" target="myFrame">Cliente</a>
                    </li>
                    <li class="nav-item active">
                        <a style="border: none; margin-left: 10px " class="btn btn-outline-light" href="Controlador?menu=Garantia&accion=Listar" target="myFrame">Garantía</a>
                    </li>
                    <li class="nav-item active">
                        <a style="border: none; margin-left: 10px " class="btn btn-outline-light" href="Controlador?menu=TelefonoProveedor&accion=listar" target="myFrame">Teléfono Proveedor</a>
                    </li>
                    <li class="nav-item active">
                        <a style="border: none; margin-left: 10px " class="btn btn-outline-light" href="Controlador?menu=Estado&accion=Listar" target="myFrame">Estado</a>
                    </li>
                </ul>
            </div>
            <div class="dropdown">
                <button class="btn btn-outline-light dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false" id="dropdownMenuButton" aria-haspopup="true" style="border: none">
                    ${usuario.getNombreEmpleado()} ${usuario.getApellidoEmpleado()}
                </button>
                <div class="dropdown-menu text-center" aria-labellebdy="dropdownMenuButton">
                    <a class="dropdown-item" href="#">
                        <img src="" alt="" width="60px"/>
                    </a>
                    <a class="dropdown-item" href="#">${usuario.getUsuario()}</a>
                    <a class="dropdown-item" href="#">Aqui va correo</a>
                    <a class="dropdown-item" href="#" target="myFrame">Proveedor</a>
                    <a class="dropdown-item" href="#" target="myFrame">Pedido</a>
                    <a class="dropdown-item" href="#" target="myFrame">Producto</a>
                    <a class="dropdown-item" href="#" target="myFrame">Detalle Pedidos</a>
                    <a class="dropdown-item" href="#" target="myFrame">Forma de Pago</a>
                    <div class="dropdown-divider"></div>
                    <form>
                        <button class="dropdown-item">Salir </button>
                    </form>
                </div>
            </div>
        </nav>
        <div class="m-4" style="height: 480px" id="iFrame">
            <iframe name="myFrame" style="height: 100%; width: 100%"></iframe>
        </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>   
    </body>
</html>
