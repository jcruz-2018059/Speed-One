
package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List listar(){
        String sql = "Select * from Pedidos";
        List<Pedido> listaPedido = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
                while(rs.next()){
                    Pedido pd = new Pedido();
                    pd.setNumeroDePedido(rs.getInt(1));
                    pd.setFechaDePedido(rs.getDate(2));
                    pd.setTotalDelPedido(rs.getDouble(3));
                    pd.setFechaDeEnvio(rs.getDate(4));
                    pd.setCodigoFormaPago(rs.getInt(5));
                    pd.setCodigoCliente(rs.getInt(6));
                    pd.setCodigoEmpleado(rs.getInt(7));
                    listaPedido.add(pd);
                    
                }
        }catch(Exception e){
            e.printStackTrace();
        
        }
        return listaPedido;
    }
    
    public int agregar(Pedido pd){
        String sql ="insert into Pedidos (numeroDePedido, fechaDePedido, totalDelPedido, fechaDeEnvio, codigoFormaPago, codigoCliente, codigoEmpleado) values (?,?,?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pd.getNumeroDePedido());
            ps.setDate(2, pd.getFechaDePedido());
            ps.setDouble(3, pd.getTotalDelPedido());
            ps.setDate(4, pd.getFechaDeEnvio());
            ps.setInt(5, pd.getCodigoFormaPago());
            ps.setInt(6, pd.getCodigoCliente());
            ps.setInt(7, pd.getCodigoEmpleado());
            ps.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se pudo agregar el registro" + e);
        }
        return resp;
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
   
   public int actualizar(Pedido pd){
       String sql = "update Pedidos set fechaDePedido = ?, totalDelPedido = ?, fechaDeEnvio = ?, codigoFormaPago = ?, codigoCliente = ?, codigoEmpleado = ? where numeroDePedido = ?";
       try{
           con = cn.Conexion();
           ps = con.prepareStatement(sql);
           ps.setDate(1 ,pd.getFechaDePedido());
           ps.setDouble(2, pd.getTotalDelPedido());
           ps.setDate(3, pd.getFechaDeEnvio());
           ps.setInt(4, pd.getCodigoFormaPago());
           ps.setInt(5, pd.getCodigoCliente());
           ps.setInt(6, pd.getCodigoEmpleado());
           ps.setInt(7, pd.getNumeroDePedido());
           ps.executeUpdate();
       }catch(Exception e){
           e.printStackTrace();
       }
       
       return resp;
   }
   
   public void eliminar (int id){
       String sql = "delete from Pedidos where numeroDePedido = " + id;
       try{
           con = cn.Conexion();
           ps = con.prepareStatement(sql);
           ps.executeUpdate();
       }catch(Exception e){
           e.printStackTrace();
       }
           
   
       
   }
   
}   
