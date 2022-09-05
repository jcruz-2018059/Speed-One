<%-- 
    Document   : Empleado
    Created on : 30/08/2022, 05:02:28 PM
    Author     : Selvi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Empleado</title>
    </head>
    <body>
        <h1 style="text-align: center; padding-top: 30px; color: #1f52a3; margin-bottom: 40px; font-size: 3rem "> Empleados</h1>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Empleado" method="POST">
                        <div class="form-group">
                            <label>DPI</label>
                            <input type="text" name="txtDPIEm" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" name="txtNombresEm" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Apellidos</label>
                            <input type="text" name="txtApellidosEm" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Telefono</label>
                            <input type="text" name="txtTelefonoEm" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" name="txtEstadoEm" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" name="txtUsuarioEm" class="form-control">
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
                            <th class="text-center text-primary" style="color: #1f52a3">DPI</th>
                            <th class="text-center text-primary" style="color: #1f52a3">NOMBRE</th>
                            <th class="text-center text-primary" style="color: #1f52a3">APELLIDO</th>
                            <th class="text-center text-primary" style="color: #1f52a3">TELEFONO</th>
                            <th class="text-center text-primary" style="color: #1f52a3">ESTADO</th>
                            <th class="text-center text-primary" style="color: #1f52a3">USUARIO</th>
                            <th class="text-center text-primary" style="color: #1f52a3">ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="empleado" items="${empleados}">
                        <tr>
                            <td class="text-center bg-primary" style="color: #fff">${empleado.getCodigoEmpleado()}</td>
                            <td class="text-center">${empleado.getDPIEmpleado()}</td>
                            <td class="text-center">${empleado.getNombreEmpleado()}</td>
                            <td class="text-center">${empleado.getApellidoEmpleado()}</td>
                            <td class="text-center">${empleado.getTelefonoEmpleado()}</td>
                            <td class="text-center">${empleado.getEstado()}</td>
                            <td class="text-center">${empleado.getUsuario()}</td>
                            <td>
                                <a class="btn btn-warning" href="">Editar</a>
                                <a class="btn btn-danger" href="">Eliminar</a>
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
