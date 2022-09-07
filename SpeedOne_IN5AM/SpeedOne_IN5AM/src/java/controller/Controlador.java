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
                    request.setAttribute("categoria", listaCategoria);
                    break;
            }
            request.getRequestDispatcher("Categoria.jsp").forward(request, response);
        } else if (menu.equals("Cliente")) {
            switch (accion) {
                case "Listar":
                    List listaCliente = clienteDAO.listar();
                    request.setAttribute("cliente", listaCliente);
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
