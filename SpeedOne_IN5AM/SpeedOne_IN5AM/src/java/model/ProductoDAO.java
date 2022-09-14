package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
     public List listar(){
    String sql = "Select * from producto";
    List<Producto> listaProducto = new ArrayList<>();
    try{
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
            Producto pro = new Producto();
            pro.setCodigoProducto(rs.getInt(1));
            pro.setNombreProducto(rs.getString(2));
            pro.setStockProducto(rs.getInt(3));
            pro.setPrecioProducto(rs.getDouble(4));
            pro.setCodigoCategoria(rs.getInt(5));
            pro.setCodigoGarantia(rs.getInt(6));
            pro.setCodigoProveedor(rs.getInt(7));
            pro.setCodigoEstadoProducto(rs.getInt(8));
            listaProducto.add(pro);
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    return listaProducto;
    }
     
    //Metodo Agregar
    public int agregar(Producto pro){
        String sql = "insert into Producto (nombreProducto, stockProducto, precioProducto, codigoCategoria, codigoProveedor, codigoGarantia, codigoEstadoProducto) values (?,?,?,?,?,?,?)";
        try{
             con = cn.Conexion();
             ps = con.prepareStatement(sql);
             ps.setString(1, pro.getNombreProducto());
             ps.setInt(2, pro.getStockProducto());
             ps.setDouble(3, pro.getPrecioProducto());
             ps.setInt(4, pro.getCodigoCategoria());
             ps.setInt(5, pro.getCodigoProveedor());
             ps.setInt(6, pro.getCodigoGarantia());
             ps.setInt(7, pro.getCodigoEstadoProducto());
             ps.executeUpdate();
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("No se pudo agregar el registro");
            }
        
        return resp;
    }
    
     //Buscar por codigo
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
    
    //Metodo editar
    public int actualizar(Producto pro){
        String sql = "update producto set nombreProducto = ?, stockProducto = ?, precioProducto = ?, codigoCategoria = ?, codigoProveedor = ?, codigoGarantia = ?, codigoEstadoProducto = ? where codigoProducto = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombreProducto());
            ps.setInt(2, pro.getStockProducto());
            ps.setDouble(3, pro.getPrecioProducto());
            ps.setInt(4, pro.getCodigoCategoria());
            ps.setInt(5, pro.getCodigoProveedor());
            ps.setInt(6, pro.getCodigoGarantia());
            ps.setInt(7, pro.getCodigoEstadoProducto());
            ps.setInt(8, pro.getCodigoProducto());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return resp;
    }
    
    //Metodo Eliminar
    public void eliminar(int id){
        String sql = "delete from Producto where codigoProducto ="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
}
