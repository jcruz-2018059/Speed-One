
package model;

import java.sql.Date;

public class Pedido {
    private int numeroDePedido;
    private Date fechaDePedido;
    private double totalDelPedido;
    private Date fechaDeEnvio;
    private int codigoFormaPago;
    private int codigoCliente;
    private int codigoEmpleado;
    
    public Pedido() {
    }

    public Pedido(int numeroDePedido, Date fechaDePedido, double totalDelPedido, Date fechaDeEnvio, int codigoFormaPago, int codigoCliente, int codigoEmpleado) {
        this.numeroDePedido = numeroDePedido;
        this.fechaDePedido = fechaDePedido;
        this.totalDelPedido = totalDelPedido;
        this.fechaDeEnvio = fechaDeEnvio;
        this.codigoFormaPago = codigoFormaPago;
        this.codigoCliente = codigoCliente;
        this.codigoEmpleado = codigoEmpleado;
    }

    public int getNumeroDePedido() {
        return numeroDePedido;
    }

    public void setNumeroDePedido(int numeroDePedido) {
        this.numeroDePedido = numeroDePedido;
    }

    public Date getFechaDePedido() {
        return fechaDePedido;
    }

    public void setFechaDePedido(Date fechaDePedido) {
        this.fechaDePedido = fechaDePedido;
    }

    public double getTotalDelPedido() {
        return totalDelPedido;
    }

    public void setTotalDelPedido(double totalDelPedido) {
        this.totalDelPedido = totalDelPedido;
    }

    public Date getFechaDeEnvio() {
        return fechaDeEnvio;
    }

    public void setFechaDeEnvio(Date fechaDeEnvio) {
        this.fechaDeEnvio = fechaDeEnvio;
    }

    public int getCodigoFormaPago() {
        return codigoFormaPago;
    }

    public void setCodigoFormaPago(int codigoFormaPago) {
        this.codigoFormaPago = codigoFormaPago;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }
}
