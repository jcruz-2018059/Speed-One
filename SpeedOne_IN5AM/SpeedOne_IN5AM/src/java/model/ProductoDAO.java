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
            pro.setPrecioProducto(rs.getInt(4));
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
}
