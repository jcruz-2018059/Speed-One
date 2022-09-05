<%-- 
    Document   : Producto
    Created on : 3/09/2022, 01:03:16 PM
    Author     : Usuario
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Vista Productos</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Producto" method="POST">
                        <div class="form-group">
                            <label>Nombre:</label>
                            <input type="text" name="txtNombreProducto" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Stock:</label>
                            <input type="text" name="txtStockProducto" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Precio:</label>
                            <input type="text" name="txtPrecioProducto" class="form-control">
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
                            <td>CODIGO</td> 
                            <td>NOMBRE</td>
                            <td>STOCK</td>
                            <td>PRECIO</td>
                            <td>COD. CATEGORIA</td>
                            <td>COD. GARANTIA</td>
                            <td>COD. PROVEEDOR</td>
                            <td>COD. ESTADO PRODUCTO</td>
                            <td>ACCIONES</td>
                        </tr>
                    </thead> 
                    <tbody>
                    <c:forEach var="producto" items="${productos}">
                        <tr>
                            <td>${producto.getCodigoProducto()}</td>
                            <td>${producto.getNombreProducto()}</td>
                            <td>${producto.getStockProducto()}</td>
                            <td>${producto.getPrecioProducto()}</td>
                            <td>${producto.getCodigoCategoria()}</td>
                            <td>${producto.getCodigoGarantia()}</td>
                            <td>${producto.getCodigoProveedor()}</td>
                            <td>${producto.getCodigoEstadoProducto()}</td>
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
