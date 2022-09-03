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
import model.Empleado;
import model.EmpleadoDAO;
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
        }else if(menu.equals("TelefonoProveedor")){
            switch(accion){
                case "listar":
                    List listaTelefonoEmpleado = telefonoDAO.listar();
                    request.setAttribute("telefonoproveedor",listaTelefonoEmpleado );
                    break;
            }
            request.getRequestDispatcher("TelefonoProveedor.jsp").forward(request, response); 
        
        }else if(menu.equals("Categoria")){
            switch(accion){
                case "Listar":
                    List listaCategoria = categoriaDAO.listar();
                    request.setAttribute("categoria", listaCategoria);
                    break;
            }
            request.getRequestDispatcher("Categoria.jsp").forward(request,response);
        }else if(menu.equals("Cliente")){
            switch(accion){
                case "Listar":
                    List listaCliente = clienteDAO.listar();
                    request.setAttribute("cliente", listaCliente);
                    break;
            }
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
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
