
package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CarritoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    
    public Cliente listarCodigoCliente(int id){
        Cliente cl = new Cliente();
        String sql = "select * from cliente where codigoCliente = " + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                cl.setNombresCliente(rs.getString(2));
                cl.setApellidosCliente(rs.getString(3));
                cl.setDireccionCliente(rs.getString(4));
                cl.setTelefonoPersonal(rs.getString(5));
                cl.setEmailCliente(rs.getString(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return cl;
    }
    
    
    public Producto listarCodigoProducto(int id){
        //Instanciar el objeto a dovolver
        Producto pro = new Producto();
        String sql = "Select * from producto where codigoProducto ="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                pro.setNombreProducto(rs.getString(2));
                pro.setStockProducto(rs.getInt(3));
                pro.setPrecioProducto(rs.getDouble(4));
                pro.setCodigoCategoria(rs.getInt(5));
                pro.setCodigoProveedor(rs.getInt(6));
                pro.setCodigoGarantia(rs.getInt(7));
                pro.setCodigoEstadoProducto(rs.getInt(8));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return pro;
    }
    
    
    public DetallePedidos listarCodigoDetallePedidos(int id){
        DetallePedidos dpd = new DetallePedidos();
        String sql = "select * from detallePedidos where codigoDetallePedidos = "+ id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                dpd.setCantidad(rs.getInt(2));
                dpd.setPrecio(rs.getDouble(3));
                dpd.setNumeroDePedido(rs.getInt(4));
                dpd.setCodigoProducto(rs.getInt(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return dpd;
    }
    
    
     public Pedido listarCodigoPedido (int id){
       Pedido pd = new Pedido();
       String sql = "select * from Pedidos where numeroDePedido = " + id;
       try{
           con = cn.Conexion();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           
           while (rs.next()){
               pd.setNumeroDePedido(rs.getInt(1));
               pd.setFechaDePedido(rs.getDate(2));
               pd.setTotalDelPedido(rs.getDouble(3));
               pd.setFechaDeEnvio(rs.getDate(4));
               pd.setCodigoFormaPago(rs.getInt(5));
               pd.setCodigoCliente(rs.getInt(6));
               pd.setCodigoEmpleado(rs.getInt(7));
           }
       }catch(Exception e){
           e.printStackTrace();
       }
       return pd;
   } 
     
     public int agregar(DetallePedidos dpd){
        String sql = "insert into DetallePedidos(cantidad, precio, numeroDePedido, codigoProducto) values (?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dpd.getCantidad());
            ps.setDouble(2, dpd.getPrecio());
            ps.setInt(3, dpd.getNumeroDePedido());
            ps.setInt(4, dpd.getCodigoProducto());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se pudo agregar el detallePedidos" + e);
        }
        return resp;
    } 
}
