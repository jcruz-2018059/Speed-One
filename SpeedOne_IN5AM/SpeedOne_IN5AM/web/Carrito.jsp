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
        <title>Carrito</title>
    </head>
    <body>
        <h1 style="text-align: center; padding-top: 30px; color: #1f52a3; margin-bottom: 40px; font-size: 3rem "> Carrito</h1>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Carrito" method="POST">
                        <label>Datos del cliente:</label>
                        <br>
                        <div class="input-group mb-3">
                              <input type="text" style="width: 160px" name="txtCodigoCliente" class="" placeholder="DPI" aria-label="Recipient's username" aria-describedby="button-addon2">
                              <a class="btn btn-outline-info" href="">Buscar Cliente</a>
                          </div>
                        <input type="text" placeholder="Nombre Cliente"  readonly  name="txtNombreCliente">
                        <br>
                        <label>Datos Producto:</label>
                          <div class="input-group mb-3">
                              <input type="text" style="width: 160px" name="txtCodigoProducto" class="" placeholder="Nombre" aria-label="Recipient's username" aria-describedby="button-addon2">
                            <button class="btn btn-outline-info" type="button" id="button-addon2">Buscar</button>
                          </div>
                        <div class="d-flex">
                            <div>
                                <input type="text" placeholder="Producto" style="margin-right: 8px" name="txtNombreProducto">
                                <input type="text" placeholder="Q.00.00" style="margin-top: 8px" name="txtPrecioProducto">
                            </div>
                            <div>
                                <input type="number" placeholder="Cant" name="txtCantidad">
                                <input type="number" placeholder="Stock" style="margin-top: 8px" name="txtStock">  
                            </div>
                        </div>
                        <input type="submit" class="btn btn-primary" style="margin-top: 8px " value="Agregar Producto">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover text-center">
                    <thead>
                        <tr>
                            <th>NUMERO</th>
                            <th>CODIGO</th>
                            <th>DESCRIPCION</th>
                            <th>PRECIO</th>
                            <th>CANTIDAD</th>
                            <th>SUB.TOTAL</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>
                                <a class="btn btn-warning">Editar</a>
                                <a class="btn btn-danger">Eliminar</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <form>
                    <input type="submit" class="btn btn-success" value="GenerarVenta">
                    <input type="submit" class="btn btn-danger" value="Cancelar">
                    <input type="text" style="height: 33px; float: right" placeholder="Q.00.00" name="txtPrecioTotal">
                </form>
            </div>
   
        </div>
        
            
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>   
    </body>
</html>
