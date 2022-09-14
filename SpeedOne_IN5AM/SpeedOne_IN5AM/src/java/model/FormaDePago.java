package model;

public class FormaDePago {
    private int codigoFormaPago;
    private String formaPago;

    public FormaDePago() {
    }

    public FormaDePago(int codigoFormaPago, String formaPago) {
        this.codigoFormaPago = codigoFormaPago;
        this.formaPago = formaPago;
    }

    public int getCodigoFormaPago() {
        return codigoFormaPago;
    }

    public void setCodigoFormaPago(int codigoFormaPago) {
        this.codigoFormaPago = codigoFormaPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }
    
    

    
    
}
