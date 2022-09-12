/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
                    request.setAttribute("telefonoproveedor", listaTelefonoEmpleado);
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
                    List garantia = garantiaDAO.listar();
                    request.setAttribute("garantias", garantia);
                    break;
            }
            request.getRequestDispatcher("Garantia.jsp").forward(request, response);
        } else if (menu.equals("Estado")) {
            switch (accion) {
                case "Listar":
                    List listaEstado = estadoDAO.listar();
                    request.setAttribute("estados", listaEstado);
                    break;
            }
            request.getRequestDispatcher("Estado.jsp").forward(request, response);
        }else if (menu.equals("Pedidos")){
            switch(accion){
                case "listar":
                    List listaProducto = pedidoDAO.listar();
                    request.setAttribute("pedidos", listaProducto);
                break;
        }
        request.getRequestDispatcher("Pedidos.jsp").forward(request, response);
        }else if (menu.equals("detallePedidos")){
            switch(accion){
                case "Listar":
                        List listaDetallePedidos = detallePedidosDAO.listar();
                        request.setAttribute("detallePedidos", listaDetallePedidos);
                        break;
            }
            request.getRequestDispatcher("DetallePedidos.jsp").forward(request, response);
        }else if(menu.equals("FormaDePago")){
            switch(accion){
                case "Listar":
                    List listaMetodo = formaDePagoDAO.listar();
                    request.setAttribute("formaDePago", listaMetodo);
                    break;
            }
            request.getRequestDispatcher("FormaDePago.jsp").forward(request,response);
        }else if(menu.equals("Producto")){
              switch(accion){
                  case "Listar":
                      List listaProductos = productoDAO.listar();
                      request.setAttribute("productos", listaProductos);
                      break;
              }
                request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }else if (menu.equals("Proveedor")) {
            switch(accion){
                case "Listar":
                    List listaProveedor = proveedorDAO.listar();
                    request.setAttribute("proveedor",listaProveedor );
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
