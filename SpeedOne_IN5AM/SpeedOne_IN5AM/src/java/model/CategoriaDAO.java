package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class CategoriaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List listar(){
        String sql = "select * from Categoria";
        List <Categoria> listaCategoria = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps. executeQuery();
            while(rs.next()){
                Categoria cat = new Categoria();
                cat.setCodigoCategoria(rs.getInt(1));
                cat.setNombreCategoria(rs.getString(2));
                cat.setDescripcionCategoria(rs.getString(3));
                listaCategoria.add(cat);
            }
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return listaCategoria;
    }
    
    
    public int agregar(Categoria cat){
        String sql = "insert into Categoria (nombreCategoria, descripcionCategoria) values(?, ?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cat.getNombreCategoria());
            ps.setString(2, cat.getDescripcionCategoria());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se pudo establecer coneccion");
        }
        return resp;
    }
    
    public Categoria listarCodigoCategoria(int id){
        Categoria cat = new Categoria();
        String sql = "Select * from categoria where codigoCategoria ="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                cat.setNombreCategoria(rs.getString(2));
                cat.setDescripcionCategoria(rs.getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return cat;
    }
    
    public int actualizar(Categoria cat){
        String sql = "update categoria set nombreCategoria = ?, descripcionCategoria = ? where codigoCategoria = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cat.getNombreCategoria());
            ps.setString(2, cat.getDescripcionCategoria());
            ps.setInt(3, cat.getCodigoCategoria());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }   
        return resp;        
    }
    
    public void elimar (int id){
        String sql = "delete from Categoria where codigoCategoria ="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}


