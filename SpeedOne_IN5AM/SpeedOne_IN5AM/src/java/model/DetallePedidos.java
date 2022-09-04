
package model;


public class DetallePedidos {
    private int codigoDetallePedidos;
    private String cantidad;
    private String precio;
    private int numeroDePedido;
    private int codigoProducto;
    
    public DetallePedidos(){
        
    }

    public DetallePedidos(int codigoDetallePedidos, String cantidad, String precio, int numeroDePedido, int codigoProducto) {
        this.codigoDetallePedidos = codigoDetallePedidos;
        this.cantidad = cantidad;
        this.precio = precio;
        this.numeroDePedido = numeroDePedido;
        this.codigoProducto = codigoProducto;
    }

    public int getCodigoDetallePedidos() {
        return codigoDetallePedidos;
    }

    public void setCodigoDetallePedidos(int codigoDetallePedidos) {
        this.codigoDetallePedidos = codigoDetallePedidos;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getNumeroDePedido() {
        return numeroDePedido;
    }

    public void setNumeroDePedido(int numeroDePedido) {
        this.numeroDePedido = numeroDePedido;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

     
    
    
}
