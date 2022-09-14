<%-- 
    Document   : Proveedor
    Created on : 3/09/2022, 02:00:20 PM
    Author     : monte
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Proveedor</title>
    </head>
    <body>
        <h1 style="text-align: center; padding-top: 30px; color: #1f52a3; margin-bottom: 40px">Proveedores</h1>
        <div class="d-flex">
            <div class="card col-lg-4">
                <div class="card-body">
                    <form action="Controlador?menu=Proveedor" method="POST">
                        <div class="form-group">
                            <label>Nombre:</label>
                            <input type="text" value="${proveedor.getNombreProveedor()}" name="txtNombreProveedor" class="form-control" placeholder="Nombre Proveedor" required>
                        </div>
                        <div class="form-group">
                            <label>Dirección:</label>
                            <input type="text" value="${proveedor.getDireccionProveedor()}" name="txtDireccionProveedor" class="form-control" placeholder="Dirección" required>
                        </div>
                        <div class="form-group">
                            <label>Teléfono de Proveedor:</label>
                            <input type="text" value="${proveedor.getCodigoTelefonoProveedor()}" name="txtCodigoTelefonoProveedor" class="form-control" placeholder="Teléfono" required>
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th class="text-center text-primary" style="color: #1f52a3">CODIGO</th>
                            <th class="text-center text-primary" style="color: #1f52a3">NOMBRE</th>
                            <th class="text-center text-primary" style="color: #1f52a3">DIRECCIÓN</th>
                            <th class="text-center text-primary" style="color: #1f52a3">TELEFONO DE PROVEEDOR</th>
                            <th class="text-center text-primary" style="color: #1f52a3">ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="proveedor" items="${proveedores}">
                        <tr>
                            <td class="text-center bg-primary" style="color: #fff">${proveedor.getCodigoProveedor()}</td>
                            <td class="text-center">${proveedor.getNombreProveedor()}</td>
                            <td class="text-center">${proveedor.getDireccionProveedor()}</td>
                            <td class="text-center">${proveedor.getCodigoTelefonoProveedor()}</td>
                            <td class="text-center">
                                <a class="btn btn-warning" href="Controlador?menu=Proveedor&accion=Editar&codigoProveedor=${proveedor.getCodigoProveedor()}">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Proveedor&accion=Eliminar&codigoProveedor=${proveedor.getCodigoProveedor()}">Eliminar</a>
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
