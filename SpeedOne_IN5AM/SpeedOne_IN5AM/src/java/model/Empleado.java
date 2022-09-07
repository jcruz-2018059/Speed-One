
package model;


public class Empleado {
    private int codigoEmpleado;
    private String DPIEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private String telefonoEmpleado;
    private String correoEmpleado;
    private String estado;
    private String usuario;

    public Empleado() {
    }

    public Empleado(int codigoEmpleado, String DPIEmpleado, String nombreEmpleado, String apellidoEmpleado, String telefonoEmpleado, String correoEmpleado, String estado, String usuario) {
        this.codigoEmpleado = codigoEmpleado;
        this.DPIEmpleado = DPIEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.telefonoEmpleado = telefonoEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.estado = estado;
        this.usuario = usuario;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getDPIEmpleado() {
        return DPIEmpleado;
    }

    public void setDPIEmpleado(String DPIEmpleado) {
        this.DPIEmpleado = DPIEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public String getTelefonoEmpleado() {
        return telefonoEmpleado;
    }

    public void setTelefonoEmpleado(String telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    
}
