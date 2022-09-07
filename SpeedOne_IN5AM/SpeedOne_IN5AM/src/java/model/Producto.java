package model;


public class Producto {
    private int codigoProducto;
    private String nombreProducto;
    private int stockProducto;
    private Double precioProducto;
    private int codigoCategoria;
    private int codigoGarantia;
    private int codigoProveedor;
    private int codigoEstadoProducto;

    public Producto() {
    }

    public Producto(int codigoProducto, String nombreProducto, int stockProducto, Double precioProducto, int codigoCategoria, int codigoGarantia, int codigoProveedor, int codigoEstadoProducto) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.stockProducto = stockProducto;
        this.precioProducto = precioProducto;
        this.codigoCategoria = codigoCategoria;
        this.codigoGarantia = codigoGarantia;
        this.codigoProveedor = codigoProveedor;
        this.codigoEstadoProducto = codigoEstadoProducto;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }

    public Double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public int getCodigoGarantia() {
        return codigoGarantia;
    }

    public void setCodigoGarantia(int codigoGarantia) {
        this.codigoGarantia = codigoGarantia;
    }

    public int getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(int codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public int getCodigoEstadoProducto() {
        return codigoEstadoProducto;
    }

    public void setCodigoEstadoProducto(int codigoEstadoProducto) {
        this.codigoEstadoProducto = codigoEstadoProducto;
    }

    
}
