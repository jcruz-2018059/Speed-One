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
}
