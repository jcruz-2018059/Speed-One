<%-- 
    Document   : Garantía
    Created on : sep 2, 2022, 3:21:00 p.m.
    Author     : Lic. César de León
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Garantía</title>
    </head>
    <body>
        <h1 style="text-align: center; padding-top: 30px; color: #1f52a3; margin-bottom: 40px; font-size: 3rem ">Garantía</h1>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Garantia" method="POST">
                        <div class="form-group">
                            <label>Tiempo de garantía: </label>
                            <input type="text" name="txtTiempoGarantia" class="form-control" value="${garantia.getTiempoGarantia()}" placeholder="Garantia" required>
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
                            <th class="text-center text-primary" style="color: #1f52a3">CÓDIGO GARANTÍA:</th>
                            <th class="text-center text-primary" style="color: #1f52a3">TIEMPO DE GARANTÍA:</th>
                            <th class="text-center text-primary" style="color: #1f52a3">ACCIONES: </th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="garantia" items="${garantias}">
                            <tr>
                                <td class="bg-primary" style="color: #fff">${garantia.getCodigoGarantia()}</td>
                                <td class="text-center">${garantia.getTiempoGarantia()}</td>
                                <td>
                                    <a href="Controlador?menu=Garantia&accion=Editar&codigoGarantia=${garantia.getCodigoGarantia()}" class="btn btn-warning">Editar</a>
                                    <a href="Controlador?menu=Garantia&accion=Eliminar&codigoGarantia=${garantia.getCodigoGarantia()}" class="btn btn-danger">Eliminar</a>
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
