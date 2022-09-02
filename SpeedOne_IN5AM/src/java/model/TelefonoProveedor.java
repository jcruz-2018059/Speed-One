
package model;


public class TelefonoProveedor {
    
    private int codigoTelefonoProveedor;
    private String telefonoProveedor;
    private String telefonoPersonal;

    public TelefonoProveedor() {
    }

    public TelefonoProveedor(int codigoTelefonoProveedor, String telefonoProveedor, String telefonoPersonal) {
        this.codigoTelefonoProveedor = codigoTelefonoProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.telefonoPersonal = telefonoPersonal;
    }

    public int getCodigoTelefonoProveedor() {
        return codigoTelefonoProveedor;
    }

    public void setCodigoTelefonoProveedor(int codigoTelefonoProveedor) {
        this.codigoTelefonoProveedor = codigoTelefonoProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getTelefonoPersonal() {
        return telefonoPersonal;
    }

    public void setTelefonoPersonal(String telefonoPersonal) {
        this.telefonoPersonal = telefonoPersonal;
    }
    
}
