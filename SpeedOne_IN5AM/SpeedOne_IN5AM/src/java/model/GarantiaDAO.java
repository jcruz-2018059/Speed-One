
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
    
}
