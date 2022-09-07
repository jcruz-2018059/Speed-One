
package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EmpleadoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Empleado validar(String usuario, String DPIEmpleado) {
       
        Empleado empleado = new Empleado();
        String sql = "select * from Empleado where usuario = ? and DPIEmpleado = ? ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, DPIEmpleado);
            rs = ps.executeQuery();
            while (rs.next()) {
                empleado.setCodigoEmpleado(rs.getInt("codigoEmpleado"));
                empleado.setDPIEmpleado(rs.getString("DPIEmpleado"));
                empleado.setNombreEmpleado(rs.getString("nombreEmpleado"));
                empleado.setApellidoEmpleado(rs.getString("apellidoEmpleado"));
                empleado.setCorreoEmpleado(rs.getString("correoEmpleado"));
                empleado.setUsuario(rs.getString("usuario"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empleado;
    }

    // Operaciones del CRUD
    // Listar
    public List listar() {
        String sql = "select * from Empleado";
        List<Empleado> listaEmpleado = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setCodigoEmpleado(rs.getInt(1));
                em.setDPIEmpleado(rs.getString(2));
                em.setNombreEmpleado(rs.getString(3));
                em.setApellidoEmpleado(rs.getString(4));
                em.setTelefonoEmpleado(rs.getString(5));
                em.setCorreoEmpleado(rs.getString(6));
                em.setEstado(rs.getString(7));
                em.setUsuario(rs.getString(8));
                listaEmpleado.add(em);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaEmpleado;
    }

    // Agregar
}
