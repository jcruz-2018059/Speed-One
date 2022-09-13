
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
    int resp;

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
                empleado.setFoto(rs.getString("foto"));
                
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
                em.setFoto(rs.getString(9));
                listaEmpleado.add(em);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaEmpleado;
    }

    // AGREGAR
     public int agregar(Empleado em){
        String sql = "insert into Empleado (DPIEmpleado, nombreEmpleado, apellidoEmpleado, telefonoEmpleado, correoEmpleado, estado, usuario, foto) values (?,?,?,?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDPIEmpleado());
            ps.setString(2, em.getNombreEmpleado());
            ps.setString(3, em.getApellidoEmpleado());
            ps.setString(4, em.getTelefonoEmpleado());
            ps.setString(5, em.getCorreoEmpleado());
            ps.setString(6, em.getEstado());
            ps.setString(7, em.getUsuario());
            ps.setString(8, em.getFoto());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se pudo agregar el registro");
        }
        
        return resp;
    }
    // BUSCAR
        public Empleado listarCodigoEmpleado(int id){
            //instanciar el objeto a devolver
            Empleado emp = new Empleado();
            String sql = "select * from empleado where codigoEmpleado = "+ id;
            try{
                con = cn.Conexion();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    emp.setDPIEmpleado(rs.getString(2));
                    emp.setNombreEmpleado(rs.getString(3));
                    emp.setApellidoEmpleado(rs.getString(4));
                    emp.setTelefonoEmpleado(rs.getString(5));
                    emp.setCorreoEmpleado(rs.getString(6));
                    emp.setEstado(rs.getString(7));
                    emp.setUsuario(rs.getString(8));
                    emp.setFoto(rs.getString(9));
                    
                }
            }catch(Exception e){ 
                e.printStackTrace();
            }
            return emp;
        }  
        
        //EDITAR
    public int actualizar(Empleado emp){
    String sql= "Update empleado set DPIEmpleado = ?, nombreEmpleado = ?, apellidoEmpleado = ?, telefonoEmpleado = ?, correoEmpleado = ?, estado = ?, usuario = ?, foto = ? where codigoEmpleado = ?";
    try{
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        ps.setString(1, emp.getDPIEmpleado());
        ps.setString(2, emp.getNombreEmpleado());
        ps.setString(3, emp.getApellidoEmpleado());
        ps.setString(4, emp.getTelefonoEmpleado());
        ps.setString(5, emp.getCorreoEmpleado());
        ps.setString(6, emp.getEstado());
        ps.setString(7, emp.getUsuario());
        ps.setString(8, emp.getFoto());
        ps.setInt(9, emp.getCodigoEmpleado());
        ps.executeUpdate();
    }catch(Exception e){
        e.printStackTrace();
    }
    return resp;
    }  
    //ELIMINAR
    public void eliminar (int id){
        String sql = "delete from Empleado where codigoEmpleado = "+id;
        try{
         con = cn.Conexion();
         ps= con.prepareStatement(sql);
         ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
