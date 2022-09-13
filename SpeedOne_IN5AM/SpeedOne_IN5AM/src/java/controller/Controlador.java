/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;
import model.CategoriaDAO;
import model.Cliente;
import model.ClienteDAO;
import model.DetallePedidos;
import model.DetallePedidosDAO;
import model.Empleado;
import model.EmpleadoDAO;
import model.Estado;
import model.EstadoDAO;
import model.FormaDePago;
import model.FormaDePagoDAO;
import model.Garantia;
import model.GarantiaDAO;
import model.Pedido;
import model.PedidoDAO;
import model.Producto;
import model.ProductoDAO;
import model.Proveedor;
import model.ProveedorDAO;
import model.TelefonoProveedor;
import model.TelefonoProveedorDAO;

/**
 *
 * @author informatica
 */
public class Controlador extends HttpServlet {

    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    Empleado empleado = new Empleado();
    TelefonoProveedor telefonoP = new TelefonoProveedor();
    TelefonoProveedorDAO telefonoDAO = new TelefonoProveedorDAO();
    Categoria categoria = new Categoria();
    CategoriaDAO categoriaDAO = new CategoriaDAO();
    Cliente cliente = new Cliente();
    ClienteDAO clienteDAO = new ClienteDAO();
    Garantia garantia = new Garantia();
    GarantiaDAO garantiaDAO = new GarantiaDAO();
    Estado estado = new Estado();
    EstadoDAO estadoDAO = new EstadoDAO();
    Pedido pedido = new Pedido();
    PedidoDAO pedidoDAO = new PedidoDAO();
    DetallePedidos detallePedidos = new DetallePedidos();
    DetallePedidosDAO detallePedidosDAO = new DetallePedidosDAO();
    FormaDePago formaDePago = new FormaDePago();
    FormaDePagoDAO formaDePagoDAO = new FormaDePagoDAO();
    Producto producto = new Producto();
    ProductoDAO productoDAO = new ProductoDAO();
    Proveedor proveedor = new Proveedor();
    ProveedorDAO proveedorDAO = new ProveedorDAO();

    int codCategoria;
    int codCliente;
    int codGarantia;
    int TelefonoProv;
    int codProveedor;
    int codProducto;
    int codEstado;
    
    int codDetallePedidos;
    int codnumeroDePedido;
    int codPedido;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        } else if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List listaEmpleados = empleadoDAO.listar();
                    request.setAttribute("empleados", listaEmpleados);
                    break;
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        } else if (menu.equals("TelefonoProveedor")) {
            switch (accion) {
                case "listar":
                    List listaTelefonoEmpleado = telefonoDAO.listar();
                    request.setAttribute("telefonoproveedores", listaTelefonoEmpleado);
                    break;

                case "Agregar":
                    String telefonoPro = request.getParameter("txtTelefonoProveedor");
                    String telefonoPer = request.getParameter("txtTelefonoPersonal");
                    telefonoP.setTelefonoProveedor(telefonoPro);
                    telefonoP.setTelefonoPersonal(telefonoPer);
                    telefonoDAO.agregar(telefonoP);
                    request.getRequestDispatcher("Controlador?menu=TelefonoProveedor&accion=listar").forward(request, response);
                    break;

                case "Editar":
                    TelefonoProv = Integer.parseInt(request.getParameter("codigoTelefonoProveedor"));
                    TelefonoProveedor T = telefonoDAO.listarCodigoTelefonoProveedor(TelefonoProv);
                    request.setAttribute("TelefonoProveedor", T);
                    request.getRequestDispatcher("Controlador?menu=TelefonoProveedor&accion=listar").forward(request, response);
                    break;

                case "Actualizar":
                    String TelefonoProveedor = request.getParameter("txtTelefonoProveedor");
                    String TelefonoPersonal = request.getParameter("txtTelefonoPersonal");
                    telefonoP.setTelefonoProveedor(TelefonoProveedor);
                    telefonoP.setTelefonoPersonal(TelefonoPersonal);
                    telefonoP.setCodigoTelefonoProveedor(TelefonoProv);
                    telefonoDAO.actualizar(telefonoP);
                    request.getRequestDispatcher("Controlador?menu=TelefonoProveedor&accion=listar").forward(request, response);
                    break;

                case "Eliminar":
                    TelefonoProv = Integer.parseInt(request.getParameter("codigoTelefonoProveedor"));
                    telefonoDAO.eliminar(TelefonoProv);
                    request.getRequestDispatcher("Controlador?menu=TelefonoProveedor&accion=listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("TelefonoProveedor.jsp").forward(request, response);

        } else if (menu.equals("Categoria")) {
            switch (accion) {
                case "Listar":
                    List listaCategoria = categoriaDAO.listar();
                    request.setAttribute("categorias", listaCategoria);
                    break;
                case "Agregar":
                    String nombres = request.getParameter("txtNombresCategoria");
                    String descrip = request.getParameter("txtDescripcion");
                    categoria.setNombreCategoria(nombres);
                    categoria.setDescripcionCategoria(descrip);
                    categoriaDAO.agregar(categoria);
                    request.getRequestDispatcher("Controlador?menu=Categoria&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codCategoria = Integer.parseInt(request.getParameter("codigoCategoria"));
                    Categoria ca = categoriaDAO.listarCodigoCategoria(codCategoria);
                    request.setAttribute("categoria", ca);
                    request.getRequestDispatcher("Controlador?menu=Categoria&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nombreCat = request.getParameter("txtNombresCategoria");
                    String descripCat = request.getParameter("txtDescripcion");
                    categoria.setNombreCategoria(nombreCat);
                    categoria.setDescripcionCategoria(descripCat);
                    categoria.setCodigoCategoria(codCategoria);
                    categoriaDAO.actualizar(categoria);
                    request.getRequestDispatcher("Controlador?menu=Categoria&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codCategoria = Integer.parseInt(request.getParameter("codigoCategoria"));
                    categoriaDAO.elimar(codCategoria);
                    request.getRequestDispatcher("Controlador?menu=Categoria&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Categoria.jsp").forward(request, response);
        } else if (menu.equals("Cliente")) {
            switch (accion) {
                case "Listar":
                    List listaCliente = clienteDAO.listar();
                    request.setAttribute("clientes", listaCliente);
                    break;
                case "Agregar":
                    String nombres = request.getParameter("txtNombresCliente");
                    String apellidos = request.getParameter("txtApellidosCliente");
                    String direccion = request.getParameter("txtDireccionCliente");
                    String telefono = request.getParameter("txtTelefonoPersonal");
                    String email = request.getParameter("txtEmailCliente");
                    cliente.setNombresCliente(nombres);
                    cliente.setApellidosCliente(apellidos);
                    cliente.setDireccionCliente(direccion);
                    cliente.setTelefonoPersonal(telefono);
                    cliente.setEmailCliente(email);
                    clienteDAO.agregar(cliente);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codCliente = Integer.parseInt(request.getParameter("codigoCliente"));
                    Cliente c = clienteDAO.listarCodigoCliente(codCliente);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nombresCl = request.getParameter("txtNombresCliente");
                    String apellidosCl = request.getParameter("txtApellidosCliente");
                    String direccionCl = request.getParameter("txtDireccionCliente");
                    String telefonoCl = request.getParameter("txtTelefonoPersonal");
                    String emailCl = request.getParameter("txtEmailCliente");
                    cliente.setNombresCliente(nombresCl);
                    cliente.setApellidosCliente(apellidosCl);
                    cliente.setDireccionCliente(direccionCl);
                    cliente.setTelefonoPersonal(telefonoCl);
                    cliente.setEmailCliente(emailCl);
                    cliente.setCodigoCliente(codCliente);
                    clienteDAO.actualizar(cliente);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codCliente = Integer.parseInt(request.getParameter("codigoCliente"));
                    clienteDAO.eliminar(codCliente);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        } else if (menu.equals("Garantia")) {
            switch (accion) {
                case "Listar":
                    List listaGarantia = garantiaDAO.listar();
                    request.setAttribute("garantias", listaGarantia);
                    break;
                case "Agregar":
                    String tiempo = request.getParameter("txtTiempoGarantia");
                    garantia.setTiempoGarantia(tiempo);
                    garantiaDAO.agregar(garantia);
                    request.getRequestDispatcher("Controlador?menu=Garantia&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codGarantia = Integer.parseInt(request.getParameter("codigoGarantia"));
                    Garantia gar = garantiaDAO.listarCodigoGarantia(codGarantia);
                    request.setAttribute("garantia", gar);
                    request.getRequestDispatcher("Controlador?menu=Garantia&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String tiempoDeGarantia = request.getParameter("txtTiempoGarantia");
                    garantia.setTiempoGarantia(tiempoDeGarantia);
                    garantia.setCodigoGarantia(codGarantia);
                    garantiaDAO.actualizar(garantia);
                    request.getRequestDispatcher("Controlador?menu=Garantia&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codGarantia = Integer.parseInt(request.getParameter("codigoGarantia"));
                    garantiaDAO.eliminar(codGarantia);
                    request.getRequestDispatcher("Controlador?menu=Garantia&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Garantia.jsp").forward(request, response);
        } else if (menu.equals("Estado")) {
            switch (accion) {
                case "Listar":
                    List listaEstado = estadoDAO.listar();
                    request.setAttribute("estados", listaEstado);
                    break;
                    
                case "Agregar":
                    String estadoPr = request.getParameter("txtEs");
                    estado.setEstadoProducto(estadoPr);
                    estadoDAO.agregar(estado);
                    request.getRequestDispatcher("Controlador?menu=Estado&accion=Listar").forward(request, response);
                    break;

                case "Editar":
                    codEstado = Integer.parseInt(request.getParameter("codigoEstadoProducto"));
                    Estado es = estadoDAO.listarCodigoEstado(codEstado);
                    request.setAttribute("estado", es);
                    request.getRequestDispatcher("Controlador?menu=Estado&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String estadoProd = request.getParameter("txtEs");
                    estado.setEstadoProducto(estadoProd);
                    estado.setCodigoEstadoProducto(codEstado);
                    estadoDAO.actualizar(estado);
                    request.getRequestDispatcher("Controlador?menu=Estado&accion=Listar").forward(request, response);
                    break;

                case "Eliminar":
                    codEstado = Integer.parseInt(request.getParameter("codigoEstadoProducto"));
                    estadoDAO.Eliminar(codEstado);
                    request.getRequestDispatcher("Controlador?menu=Estado&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Estado.jsp").forward(request, response);
        } else if (menu.equals("Pedidos")) {
            switch (accion) {
                case "listar":
                    List listaProducto = pedidoDAO.listar();
                    request.setAttribute("pedidos", listaProducto);
                    break;
                case "Agregar":
                    int numPedido = Integer.parseInt(request.getParameter("txtNumeroPedido"));
                    Date fPedido = Date.valueOf(request.getParameter("txtFechaPedido"));
                    double totPedido = Double.parseDouble(request.getParameter("txtTotalPedido"));
                    Date fEnvio = Date.valueOf(request.getParameter("txtFechaEnvio"));
                    int codFPago = Integer.parseInt(request.getParameter("txtCodigoFormaPago"));
                    int codCliente = Integer.parseInt(request.getParameter("txtCodigoCliente"));
                    int codEmpleado = Integer.parseInt(request.getParameter("txtCodigoEmpleado"));
                    pedido.setNumeroDePedido(numPedido);
                    pedido.setFechaDePedido(fPedido);
                    pedido.setTotalDelPedido(totPedido);
                    pedido.setFechaDeEnvio(fEnvio);
                    pedido.setCodigoFormaPago(codFPago);
                    pedido.setCodigoCliente(codCliente);
                    pedido.setCodigoEmpleado(codEmpleado);
                    pedidoDAO.agregar(pedido);
                    request.getRequestDispatcher("Controlador?menu=Pedidos&accion=listar").forward(request, response);
                break;
                case "Editar":
                    codPedido = Integer.parseInt(request.getParameter("numeroDePedido"));
                    Pedido p = pedidoDAO.listarCodigoPedido(codPedido);
                    request.setAttribute("pedido", p);
                    request.getRequestDispatcher("Controlador?menu=Pedidos&accion=listar").forward(request, response);
                break;
                case "Actualizar":
                    Date fecPedido = Date.valueOf(request.getParameter("txtFechaPedido"));
                    double tPedido = Double.parseDouble(request.getParameter("txtTotalPedido"));
                    Date fecEnvio = Date.valueOf(request.getParameter("txtFechaEnvio"));
                    int cFPago = Integer.parseInt(request.getParameter("txtCodigoFormaPago"));
                    int cCliente = Integer.parseInt(request.getParameter("txtCodigoCliente"));
                    int cEmpleado = Integer.parseInt(request.getParameter("txtCodigoEmpleado"));
                    pedido.setFechaDePedido(fecPedido);
                    pedido.setTotalDelPedido(tPedido);
                    pedido.setFechaDeEnvio(fecEnvio);
                    pedido.setCodigoFormaPago(cFPago);
                    pedido.setCodigoCliente(cCliente);
                    pedido.setCodigoEmpleado(cEmpleado);
                    pedido.setNumeroDePedido(codPedido);
                    pedidoDAO.actualizar(pedido);
                    request.getRequestDispatcher("Controlador?menu=Pedidos&accion=listar").forward(request, response);
                break;
                case "Eliminar":
                    codPedido = Integer.parseInt(request.getParameter("numeroDePedido"));
                    pedidoDAO.eliminar(codPedido);
                    request.getRequestDispatcher("Controlador?menu=Pedidos&accion=listar").forward(request, response);
                break;
            }
            request.getRequestDispatcher("Pedidos.jsp").forward(request, response);
        } else if (menu.equals("detallePedidos")) {
            switch (accion) {
                case "Listar":
                    List listaDetallePedidos = detallePedidosDAO.listar();
                    request.setAttribute("detallePedidos", listaDetallePedidos);
                    break;
                case "Agregar":   
                    int cant = Integer.parseInt(request.getParameter("txtCantidad"));
                    double pre = Double.parseDouble(request.getParameter("txtPrecio"));
                    int codnum = Integer.parseInt(request.getParameter("txtPedidos"));
                    int codPro = Integer.parseInt(request.getParameter("txtProductos"));
                    detallePedidos.setCantidad(cant);
                    detallePedidos.setPrecio(pre);
                    detallePedidos.setNumeroDePedido(codnum);
                    detallePedidos.setCodigoProducto(codPro);
                    detallePedidosDAO.agregar(detallePedidos);
                    
                    request.getRequestDispatcher("Controlador?menu=detallePedidos&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                   // String blockeador = request.getParameter("txtPedidos");
                   // blockeador
                    codDetallePedidos = Integer.parseInt(request.getParameter("codigoDetallePedidos"));
                    DetallePedidos d = detallePedidosDAO.listarCodigoDetallePedidos(codDetallePedidos);
                    request.setAttribute("detallePedido", d);
                    request.getRequestDispatcher("Controlador?menu=detallePedidos&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    int cantidadDpd = Integer.parseInt(request.getParameter("txtCantidad"));
                    double precioDpd = Double.parseDouble(request.getParameter("txtPrecio"));
                    int codnumDpd = Integer.parseInt(request.getParameter("txtPedidos"));
                    int codProDpd = Integer.parseInt(request.getParameter("txtProductos"));
                    detallePedidos.setCantidad(cantidadDpd);
                    detallePedidos.setPrecio(precioDpd);
                    detallePedidos.setNumeroDePedido(codnumDpd);
                    detallePedidos.setCodigoProducto(codProDpd);
                    detallePedidos.setCodigoDetallePedidos(codDetallePedidos);
                    detallePedidosDAO.actualizar(detallePedidos);
                    request.getRequestDispatcher("Controlador?menu=detallePedidos&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codDetallePedidos = Integer.parseInt(request.getParameter("codigoDetallePedidos"));
                    detallePedidosDAO.Eliminar(codDetallePedidos);
                    request.getRequestDispatcher("Controlador?menu=detallePedidos&accion=Listar").forward(request, response);
                    break;
            
            }
            request.getRequestDispatcher("DetallePedidos.jsp").forward(request, response);
        } else if (menu.equals("FormaDePago")) {
            switch (accion) {
                case "Listar":
                    List listaMetodo = formaDePagoDAO.listar();
                    request.setAttribute("formaDePago", listaMetodo);
                    break;
            }
            request.getRequestDispatcher("FormaDePago.jsp").forward(request, response);
        } else if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List listaProductos = productoDAO.listar();
                    request.setAttribute("productos", listaProductos);
                    break;
                case "Agregar":
                    String nombre = request.getParameter("txtNombreProducto");
                    int stock = Integer.parseInt(request.getParameter("txtStockProducto"));
                    double precio = Double.parseDouble(request.getParameter("txtPrecioProducto"));
                    int catego = Integer.parseInt(request.getParameter("txtCodigoCategoria"));
                    int prove = Integer.parseInt(request.getParameter("txtCodigoProveedor"));
                    int gara = Integer.parseInt(request.getParameter("txtCodigoGarantia"));
                    int estaprodu = Integer.parseInt(request.getParameter("txtCodigoEstadoProducto"));
                    producto.setNombreProducto(nombre);
                    producto.setStockProducto(stock);
                    producto.setPrecioProducto(precio);
                    producto.setCodigoCategoria(catego);
                    producto.setCodigoProveedor(prove);
                    producto.setCodigoGarantia(gara);
                    producto.setCodigoEstadoProducto(estaprodu);
                    productoDAO.agregar(producto);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codProducto = Integer.parseInt(request.getParameter("codigoProducto"));
                    Producto p = productoDAO.listarCodigoProducto(codProducto);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nombrePro = request.getParameter("txtNombreProducto");
                    int stockPro = Integer.parseInt(request.getParameter("txtStockProducto"));
                    double precioPro = Double.parseDouble(request.getParameter("txtPrecioProducto"));
                    int categoPro = Integer.parseInt(request.getParameter("txtCodigoCategoria"));
                    int provePro = Integer.parseInt(request.getParameter("txtCodigoProveedor"));
                    int garaPro = Integer.parseInt(request.getParameter("txtCodigoGarantia"));
                    int estaproduPro = Integer.parseInt(request.getParameter("txtCodigoEstadoProducto"));
                    producto.setNombreProducto(nombrePro);
                    producto.setStockProducto(stockPro);
                    producto.setPrecioProducto(precioPro);
                    producto.setCodigoCategoria(categoPro);
                    producto.setCodigoProveedor(provePro);
                    producto.setCodigoGarantia(garaPro);
                    producto.setCodigoEstadoProducto(estaproduPro);
                    producto.setCodigoProducto(codProducto);
                    productoDAO.actualizar(producto);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codProducto = Integer.parseInt(request.getParameter("codigoProducto"));
                    productoDAO.eliminar(codProducto);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        } else if (menu.equals("Proveedor")) {
            switch (accion) {
                case "Listar":
                    List listaProveedor = proveedorDAO.listar();
                    request.setAttribute("proveedores", listaProveedor);
                    break;
                case "Agregar":
                    String nombre = request.getParameter("txtNombreProveedor");
                    String direccion = request.getParameter("txtDireccionProveedor");
                    int telefonoProveedor = Integer.parseInt(request.getParameter("txtCodigoTelefonoProveedor"));
                    proveedor.setNombreProveedor(nombre);
                    proveedor.setDireccionProveedor(direccion);
                    proveedor.setCodigoTelefonoProveedor(telefonoProveedor);
                    proveedorDAO.agregar(proveedor);
                    request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codProveedor = Integer.parseInt(request.getParameter("codigoProveedor"));
                    Proveedor p = proveedorDAO.listarCodigoProveedor(codProveedor);
                    request.setAttribute("proveedor", p);
                    request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nombreProv = request.getParameter("txtNombreProveedor");
                    String direccionProv = request.getParameter("txtDireccionProveedor");
                    int codigoTelefonoProveedorProv = Integer.parseInt(request.getParameter("txtCodigoTelefonoProveedor"));
                    proveedor.setNombreProveedor(nombreProv);
                    proveedor.setDireccionProveedor(direccionProv);
                    proveedor.setCodigoTelefonoProveedor(codigoTelefonoProveedorProv);
                    proveedor.setCodigoProveedor(codProveedor);
                    proveedorDAO.actualizar(proveedor);
                    request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codProveedor = Integer.parseInt(request.getParameter("codigoProveedor"));
                    proveedorDAO.eliminar(codProveedor);
                    request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Proveedor.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
