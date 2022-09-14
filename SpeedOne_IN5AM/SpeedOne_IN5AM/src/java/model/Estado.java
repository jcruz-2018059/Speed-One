
package model;

public class Estado {
    private int codigoEstadoProducto;
    private String estadoProducto;

    public Estado(int codigoEstadoProducto, String estadoProducto) {
        this.codigoEstadoProducto = codigoEstadoProducto;
        this.estadoProducto = estadoProducto;
    }

    public Estado() {
    }

    public int getCodigoEstadoProducto() {
        return codigoEstadoProducto;
    }

    public void setCodigoEstadoProducto(int codigoEstadoProducto) {
        this.codigoEstadoProducto = codigoEstadoProducto;
    }

    public String getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(String estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    
}
