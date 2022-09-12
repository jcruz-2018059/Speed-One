package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List listar(){
    String sql = "Select * from Proveedor";
        List <Proveedor> listaProveedor = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps. executeQuery();
            while(rs.next()){
                Proveedor prov = new Proveedor();
                prov.setCodigoProveedor(rs.getInt(1));
                prov.setNombreProveedor(rs.getString(2));
                prov.setDireccionProveedor(rs.getString(3));
                prov.setCodigoTelefonoProveedor(rs.getInt(4));
                listaProveedor.add(prov);
            }
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return listaProveedor;
    }
    public int agregar(Proveedor prov){
        String sql = "insert into Proveedor(nombreProveedor, direccionProveedor, codigoTelefonoProveedor) values(?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prov.getNombreProveedor());
            ps.setString(2, prov.getDireccionProveedor());
            ps.setInt(3, prov.getCodigoTelefonoProveedor());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se pudo agregar el registro");
        }
        return resp;  
    }
    public Proveedor listarCodigoProveedor(int id){
        Proveedor prov = new Proveedor();
        String sql = "Select * from proveedor where codigoProveedor = "+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                prov.setNombreProveedor(rs.getString(2));
                prov.setDireccionProveedor(rs.getString(3));
                prov.setCodigoTelefonoProveedor(rs.getInt(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }   
        return prov;
    }
    
    public int actualizar(Proveedor prov){
        String sql = "update proveedor set nombreProveedor = ?, direccionProveedor = ?, codigoTelefonoProveedor = ? where codigoProveedor = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prov.getNombreProveedor());
            ps.setString(2, prov.getDireccionProveedor());
            ps.setInt(3, prov.getCodigoTelefonoProveedor());
            ps.setInt(4, prov.getCodigoProveedor());
            ps.executeUpdate();           
        }catch(Exception e){
            e.printStackTrace();
        }   
        return resp;
    }
    
    public void eliminar(int id){
        String sql = "delete from Proveedor where codigoProveedor ="+id;
        try{
           con = cn.Conexion();
           ps = con.prepareStatement(sql);
           ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
