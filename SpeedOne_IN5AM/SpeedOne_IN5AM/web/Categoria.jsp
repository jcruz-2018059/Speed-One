<%-- 
    Document   : Categoria
    Created on : 02-sep-2022, 15:35:42
    Author     : julio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Categoria</title>
    </head>
    <body>
        <h1 style="text-align: center; padding-top: 30px; color: #1f52a3; margin-bottom: 40px; font-size: 3rem ">Clientes</h1>
        <div class="d-flex">
            <div class="card col-lg-4">
                <div class="card-body">
                    <form action="Controlador?menu=Categoria" method="POST">
                        <div class="form-group">
                            <label>Nombre:</label>
                            <input type="text" value="${categoria.getNombreCategoria()}" name="txtNombresCategoria" class="form-control" placeholder="Nombre" required >
                        </div>
                        <div class="form-group">
                            <label>Descripción:</label>
                            <input type="text" value="${categoria.getDescripcionCategoria()}" name="txtDescripcion" class="form-control" placeholder="Descripción" required >
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover text-center">
                    <thead>
                        <tr>
                            <th class="text-center text-primary" style="color: #1f52a3">CODIGO</th>
                            <th class="text-center text-primary" style="color: #1f52a3">NOMBRE</th>
                            <th class="text-center text-primary" style="color: #1f52a3">DESCRIPCION</th>
                            <th class="text-center text-primary" style="color: #1f52a3">ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="categoria" items="${categorias}">
                        <tr>
                            <td class="bg-primary" style="color: #fff">${categoria.getCodigoCategoria()}</td>
                            <td class="text-center">${categoria.getNombreCategoria()}</td>
                            <td class="text-center">${categoria.getDescripcionCategoria()}</td>
                            <td class="text-center">
                                <a class="btn btn-warning" href="Controlador?menu=Categoria&accion=Editar&codigoCategoria=${categoria.getCodigoCategoria()}">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Categoria&accion=Eliminar&codigoCategoria=${categoria.getCodigoCategoria()}">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        
        
        
         <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
