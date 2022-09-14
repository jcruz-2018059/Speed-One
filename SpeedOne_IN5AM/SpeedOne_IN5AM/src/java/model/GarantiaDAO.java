
package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GarantiaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int codCat;
    
    public List listar(){
        List<Garantia> listaGarantia = new ArrayList<>();
        String sql = "select * from Garantia";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Garantia garantia = new Garantia();
                garantia.setCodigoGarantia(rs.getInt(1));
                garantia.setTiempoGarantia(rs.getString(2));
                listaGarantia.add(garantia);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaGarantia;
    }
    
    public int agregar(Garantia gar){
        String sql = "insert into Garantia(tiempoGarantia) values(?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, gar.getTiempoGarantia());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se pudo agregar: " + e);
        }
        return codCat;
    }
    
    public Garantia listarCodigoGarantia(int id){
        Garantia gar = new Garantia();
        String sql = "select * from Garantia where codigoGarantia = " + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                gar.setTiempoGarantia(rs.getString(2));
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se guardo el Código: " + e);
        }
        return gar;
    }
    
    public int actualizar(Garantia gar){
        String sql = "Update Garantia set tiempoGarantia = ? where codigoGarantia = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, gar.getTiempoGarantia());
            ps.setInt(2, gar.getCodigoGarantia());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return codCat;
    }
    
    public int eliminar(int id){
        String sql = "delete from Garantia where codigoGarantia = " + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se elimino a nadie: " + e);
        }
        return codCat;
    }
    
}
