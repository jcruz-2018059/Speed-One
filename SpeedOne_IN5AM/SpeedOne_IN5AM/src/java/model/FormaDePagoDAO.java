package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FormaDePagoDAO {
   
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        String sql = "select * from formaDePago";
        List <FormaDePago> listaMetodo = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps. executeQuery();
            while(rs.next()){
                FormaDePago Mepa = new FormaDePago();
                Mepa.setCodigoFormaPago(rs.getInt(1));
                Mepa.setFormaPago(rs.getString(2));
                listaMetodo.add(Mepa);
            }
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return listaMetodo;
    }
}
