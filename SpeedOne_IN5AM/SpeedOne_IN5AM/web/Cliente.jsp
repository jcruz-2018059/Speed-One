<%-- 
    Document   : Cliente
    Created on : 2/09/2022, 03:54:50 PM
    Author     : Eduardo Cruz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Vista Clientes</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Cliente" method="POST">
                        <div class="form-group">
                            <label>Nombres: </label>
                            <input type="text" value="${cliente.getNombresCliente()}" name="txtNombresCliente" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>Apellidos: </label>
                            <input type="text" value="${cliente.getApellidosCliente()}" name="txtApellidosCliente" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>Dirección: </label>
                            <input type="text" value="${cliente.getDireccionCliente()}" name="txtDireccionCliente" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>Teléfono: </label>
                            <input type="text" value="${cliente.getTelefonoPersonal()}" name="txtTelefonoPersonal" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>E-mail </label>
                            <input type="text" value="${cliente.getEmailCliente()}" name="txtEmailCliente" class="form-control" />
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
                            <td>Código</td>
                            <td>Nombres</td>
                            <td>Apellidos</td>
                            <td>Dirección</td>
                            <td>No. de Teléfono</td>
                            <td>E-mail</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cliente" items="${clientes}">
                        <tr>
                            <td>${cliente.getCodigoCliente()}</td>
                            <td>${cliente.getNombresCliente()}</td>
                            <td>${cliente.getApellidosCliente()}</td>
                            <td>${cliente.getDireccionCliente()}</td>
                            <td>${cliente.getTelefonoPersonal()}</td>
                            <td>${cliente.getEmailCliente()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Cliente&accion=Editar&codigoCliente=${cliente.getCodigoCliente()}">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Cliente&accion=Eliminar&codigoCliente=${cliente.getCodigoCliente()}">Eliminar</a>
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