
package model;

public class Garantia {
    private int codigoGarantia;
    private String tiempoGarantia;

    public Garantia() {
    }

    public Garantia(int codigoGarantia, String tiempoGarantia) {
        this.codigoGarantia = codigoGarantia;
        this.tiempoGarantia = tiempoGarantia;
    }

    public int getCodigoGarantia() {
        return codigoGarantia;
    }

    public void setCodigoGarantia(int codigoGarantia) {
        this.codigoGarantia = codigoGarantia;
    }

    public String getTiempoGarantia() {
        return tiempoGarantia;
    }

    public void setTiempoGarantia(String tiempoGarantia) {
        this.tiempoGarantia = tiempoGarantia;
    }
    
    
}
