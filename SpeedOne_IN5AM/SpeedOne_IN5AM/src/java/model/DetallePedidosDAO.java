
package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DetallePedidosDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    
    
    public List listar(){
        String sql = "select * from DetallePedidos";
        List <DetallePedidos> listaDetallePedidos = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                DetallePedidos dp = new DetallePedidos();
                dp.setCodigoDetallePedidos(rs.getInt(1));
                dp.setCantidad(rs.getInt(2));
                dp.setPrecio(rs.getDouble(3));
                dp.setNumeroDePedido(rs.getInt(4));
                dp.setCodigoProducto(rs.getInt(5));
                listaDetallePedidos.add(dp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaDetallePedidos;
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
    
    public int actualizar(DetallePedidos dpd){
        String sql = "update detallePedidos set cantidad = ?, precio = ?, numeroDePedido = ?, codigoProducto = ? where codigoDetallePedidos = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dpd.getCantidad());
            ps.setDouble(2, dpd.getPrecio());
            ps.setInt(3, dpd.getNumeroDePedido());
            ps.setInt(4, dpd.getCodigoProducto());
            ps.setInt(5, dpd.getCodigoDetallePedidos());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    public void Eliminar(int id){
        String sql = "delete from DetallePedidos where codigoDetallePedidos ="+ id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
