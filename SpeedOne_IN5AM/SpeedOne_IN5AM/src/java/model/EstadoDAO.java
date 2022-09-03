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
}
