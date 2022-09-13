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
    int resp;
    
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
    public int agregar(FormaDePago Mepa) {
        String sql = "insert into FormaDePago(formaPago) values(?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, Mepa.getFormaPago());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public FormaDePago listarCodigoFormaPago(int id) {
        FormaDePago Mepa = new FormaDePago();
        String sql = "Select * from FormaDePago where codigoFormaPago = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mepa.setCodigoFormaPago(rs.getInt(1));
                Mepa.setFormaPago(rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Mepa;
    }

    public int actualizar(FormaDePago Mepa) {
        String sql = "update FormaDePago set formaPago = ? where codigoFormaPago = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, Mepa.getFormaPago());
            ps.setInt(2, Mepa.getCodigoFormaPago());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public void Eliminar(int id) {
        String sql = "delete from formaDePago where codigoFormaPago =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
