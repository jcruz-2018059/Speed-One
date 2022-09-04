<%-- 
    Document   : Producto
    Created on : 2/09/2022, 05:37:56 PM
    Author     : pg409
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedidos</title>
    </head>
    <body class="d-flex">
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Producto" method="POST">
                        <div class="form-group">
                            <label>Fecha Pedido:</label>
                            <input type="text" name="txtNombreProducto" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Total de Pedido:</label>
                            <input type="text" name="txtStockProducto" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Fecha de Envio:</label>
                            <input type="text" name="txtPrecioProducto" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Codigo Forma Pago :</label>
                            <input type="text" name="txtCodigoCategoria" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Codigo Cliente:</label>
                            <input type="text" name="txtCodigoCategoria" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Codigo Empleado:</label>
                            <input type="text" name="txtCodigoProveedor" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info" >
                        <input type ="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <td>NUMERO DE PEDIDO</td>
                            <td>FECHA DE PEDIDO</td>
                            <td>TOTAL</td>
                            <td>FECHA DE ENVIO</td>
                            <td>CODIGO FORMA PAGO</td>
                            <td>CODIGO CLIENTE</td>
                            <td>CODIGO EMPLEADO</td>
                            <td>ACCIONES</td>   
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pedido" items="${pedidos}">
                            <tr>
                                <td>${pedido.getNumeroDePedido()}</td>
                                <td>${pedido.getFechaDePedido()}</td>
                                <td>${pedido.getTotalDelPedido()}</td>
                                <td>${pedido.getFechaDeEnvio()}</td>
                                <td>${pedido.getCodigoFormaPago()}</td>
                                <td>${pedido.getCodigoCliente()}</td>
                                <td>${pedido.getCodigoEmpleado()}</td>
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
