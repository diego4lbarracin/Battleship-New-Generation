package model;

public class Barco {
    private String tipoBarco;
    private int tamanoBarco;
    private String posicionInicio;
    private String posiconFinal;
    private int idTipoBarco;

    public Barco(String tipoBarco, int tamanoBarco, int idTipoBarco) {
        this.tipoBarco = tipoBarco;
        this.tamanoBarco = tamanoBarco;
        this.idTipoBarco = idTipoBarco;
//        this.posicionInicio = posicionInicio;
//        this.posiconFinal = posiconFinal;
    }

    public String getTipoBarco() {
        return tipoBarco;
    }

    public void setTipoBarco(String tipoBarco) {
        this.tipoBarco = tipoBarco;
    }

    public int getTamanoBarco() {
        return tamanoBarco;
    }

    public int getIdTipoBarco() {
        return idTipoBarco;
    }

    public void setIdTipoBarco(int idTipoBarco) {
        this.idTipoBarco = idTipoBarco;
    }

    public void setTamanoBarco(int tamanoBarco) {
        this.tamanoBarco = tamanoBarco;
    }

    public String getPosicionInicio() {
        return posicionInicio;
    }

    public void setPosicionInicio(String posicionInicio) {
        this.posicionInicio = posicionInicio;
    }

    public String getPosiconFinal() {
        return posiconFinal;
    }

    public void setPosiconFinal(String posiconFinal) {
        this.posiconFinal = posiconFinal;
    }
}
