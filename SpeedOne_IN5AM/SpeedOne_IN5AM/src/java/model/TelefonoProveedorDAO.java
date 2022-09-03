
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
}

