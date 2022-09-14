
package model;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TelefonoProveedorDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    
    public List listar(){
        String sql = "Select * from TelefonoProveedor";
        List<TelefonoProveedor> listaTelefonoProveedor = new ArrayList<>();
        try{
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
            while(rs.next()){
                TelefonoProveedor tf = new TelefonoProveedor();
                tf.setCodigoTelefonoProveedor(rs.getInt(1));
                tf.setTelefonoProveedor(rs.getString(2));
                tf.setTelefonoPersonal(rs.getString(3));
                listaTelefonoProveedor.add(tf);
            }
    }catch(Exception e){
        e.printStackTrace();
    }
    return listaTelefonoProveedor;
}
   public int agregar(TelefonoProveedor tf){
        String sql = "insert into TelefonoProveedor (telefonoProveedor, telefonoPersonal) values (?,?)";
        try{
             con = cn.Conexion();
             ps = con.prepareStatement(sql);
             ps.setString(1, tf.getTelefonoProveedor());
             ps.setString(2, tf.getTelefonoPersonal());
             ps.executeUpdate();
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("No se pudo agregar el registro");
            }      
        return resp;
    }
    

    public TelefonoProveedor listarCodigoTelefonoProveedor(int id){
         TelefonoProveedor tf = new TelefonoProveedor();
        String sql = "Select * from TelefonoProveedor where codigoTelefonoProveedor ="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                tf.setTelefonoProveedor(rs.getString(2));
                tf.setTelefonoPersonal(rs.getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }      
        return tf;
    }
    
    
     public int actualizar(TelefonoProveedor tf){
        String sql = "update telefonoProveedor set telefonoProveedor = ?, telefonoPersonal = ? where codigoTelefonoProveedor = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tf.getTelefonoProveedor());
            ps.setString(2, tf.getTelefonoPersonal());
            ps.setInt(3, tf.getCodigoTelefonoProveedor());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }        
        return resp;
    }
     
     
         public void eliminar(int id){
        String sql = "delete from telefonoProveedor where codigoTelefonoProveedor ="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    
}

