package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    //Listar
    public List listar(){
        String sql = "select * from cliente";
        List<Cliente> listaCliente = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Cliente cl = new Cliente();
                cl.setCodigoCliente(rs.getInt(1));
                cl.setNombresCliente(rs.getString(2));
                cl.setApellidosCliente(rs.getString(3));
                cl.setDireccionCliente(rs.getString(4));
                cl.setTelefonoPersonal(rs.getString(5));
                cl.setEmailCliente(rs.getString(6));
                listaCliente.add(cl);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaCliente;
    }
}
