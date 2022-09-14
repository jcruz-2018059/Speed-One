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
    <body>
        <h1 style="text-align: center; padding-top: 30px; color: #1f52a3; margin-bottom: 40px; font-size: 3rem "> Pedidos</h1>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Pedidos" method="POST">
                        <div class="form-group">
                            <label>Número Pedido:</label>
                            <input type="text" value="${pedido.getNumeroDePedido()}" name="txtNumeroPedido" class="form-control" placeholder="No. Pedido" required>
                        </div>
                        <div class="form-group">
                            <label>Fecha Pedido:</label>
                            <input type="text" value="${pedido.getFechaDePedido()}" name="txtFechaPedido" class="form-control" placeholder="Fecha del Pedido" required>
                        </div>
                        <div class="form-group">
                            <label>Total de Pedido:</label>
                            <input type="text" value="${pedido.getTotalDelPedido()}" name="txtTotalPedido" class="form-control" placeholder="Q.00.00" required>
                        </div>
                        <div class="form-group">
                            <label>Fecha de Envio:</label>
                            <input type="text" value="${pedido.getFechaDeEnvio()}" name="txtFechaEnvio" class="form-control" placeholder="Fecha de envio" required>
                        </div>
                        <div class="form-group">
                            <label>Código Forma Pago :</label>
                            <input type="text" value="${pedido.getCodigoFormaPago()}" name="txtCodigoFormaPago" class="form-control" placeholder="Cod. Forma de pago" required>
                        </div>
                        <div class="form-group">
                            <label>Código Cliente:</label>
                            <input type="text" value="${pedido.getCodigoCliente()}" name="txtCodigoCliente" class="form-control" placeholder="Cod. Cliente" required>
                        </div>
                        <div class="form-group">
                            <label>Código Empleado:</label>
                            <input type="text" value="${pedido.getCodigoEmpleado()}" name="txtCodigoEmpleado" class="form-control" placeholder="Cod Empleado" required>
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
                            <th class="text-center text-primary" style="color: #1f52a3">NÚMERO DE PEDIDO</th>
                            <th class="text-center text-primary" style="color: #1f52a3">FECHA DE PEDIDO</th>
                            <th class="text-center text-primary" style="color: #1f52a3">TOTAL</td>
                            <th class="text-center text-primary" style="color: #1f52a3">FECHA DE ENVIO</th>
                            <th class="text-center text-primary" style="color: #1f52a3">CÓDIGO FORMA PAGO</th>
                            <th class="text-center text-primary" style="color: #1f52a3">CÓDIGO CLIENTE</th>
                            <th class="text-center text-primary" style="color: #1f52a3">CÓDIGO EMPLEADO</th>
                            <th class="text-center text-primary" style="color: #1f52a3">ACCIONES</th>   
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pedido" items="${pedidos}">
                            <tr>
                                <td class="bg-primary" style="color: #fff">${pedido.getNumeroDePedido()}</td>
                                <td class="text-center">${pedido.getFechaDePedido()}</td>
                                <td class="text-center">${pedido.getTotalDelPedido()}</td>
                                <td class="text-center">${pedido.getFechaDeEnvio()}</td>
                                <td class="text-center">${pedido.getCodigoFormaPago()}</td>
                                <td class="text-center">${pedido.getCodigoCliente()}</td>
                                <td class="text-center">${pedido.getCodigoEmpleado()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Pedidos&accion=Editar&numeroDePedido=${pedido.getNumeroDePedido()}">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Pedidos&accion=Eliminar&numeroDePedido=${pedido.getNumeroDePedido()}">Eliminar</a>
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
