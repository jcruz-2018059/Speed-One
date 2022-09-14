package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List listar() {
        String sql = "Select * from EstadoProducto";
        List<Estado> listaEstado = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Estado et = new Estado();
                et.setCodigoEstadoProducto(rs.getInt(1));
                et.setEstadoProducto(rs.getString(2));
                listaEstado.add(et);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaEstado;
    }

    public int agregar(Estado est) {
        String sql = "insert into EstadoProducto(estadoProducto) values( ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, est.getEstadoProducto());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public Estado listarCodigoEstado(int id) {
        Estado est = new Estado();
        String sql = "Select * from EstadoProducto where codigoEstadoProducto = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                est.setCodigoEstadoProducto(rs.getInt(1));
                est.setEstadoProducto(rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return est;
    }

    public int actualizar(Estado est) {
        String sql = "update EstadoProducto set estadoProducto = ? where codigoEstadoProducto = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, est.getEstadoProducto());
            ps.setInt(2, est.getCodigoEstadoProducto());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public void Eliminar(int id) {
        String sql = "delete from EstadoProducto where codigoEstadoProducto =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
