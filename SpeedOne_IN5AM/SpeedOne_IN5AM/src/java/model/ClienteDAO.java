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
    int resp;
    
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
    //Agregar
    public int agregar(Cliente cl){
        String sql = "insert into Cliente(nombresCliente, apellidosCliente, direccionCliente, telefonoPersonal, emailCliente) values(?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getNombresCliente());
            ps.setString(2, cl.getApellidosCliente());
            ps.setString(3, cl.getDireccionCliente());
            ps.setString(4, cl.getTelefonoPersonal());
            ps.setString(5, cl.getEmailCliente());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se pudo agregar el registro");
        }
        return resp;
    }
    
    //Buscar
    public Cliente listarCodigoCliente(int id){
        Cliente cl = new Cliente();
        String sql = "select * from cliente where codigoCliente = " + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                cl.setNombresCliente(rs.getString(2));
                cl.setApellidosCliente(rs.getString(3));
                cl.setDireccionCliente(rs.getString(4));
                cl.setTelefonoPersonal(rs.getString(5));
                cl.setEmailCliente(rs.getString(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return cl;
    }
    
    //Editar
    public int actualizar(Cliente cl){
        String sql = "update cliente set nombresCliente = ?, apellidosCliente = ?, direccionCliente = ?, telefonoPersonal = ?, emailCliente = ? where codigoCliente = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getNombresCliente());
            ps.setString(2, cl.getApellidosCliente());
            ps.setString(3, cl.getDireccionCliente());
            ps.setString(4, cl.getTelefonoPersonal());
            ps.setString(5, cl.getEmailCliente());
            ps.setInt(6, cl.getCodigoCliente());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    //Eliminar
    public void eliminar(int id){
        String sql = "delete from Cliente where codigoCliente = " + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
