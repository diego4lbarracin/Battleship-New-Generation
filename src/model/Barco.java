package model;

public class Barco {
    /*Clase Barco: La clase barco contiene los atributos y métodos asociados a cada barco.*/

    /*Atributos de la clase.*/
    private String tipoBarco;
    private int tamanoBarco;
    private String posicionInicio;
    private String posiconFinal;
    private int idTipoBarco;
    /*Método constructor de la clase Barco.*/
    public Barco(String tipoBarco, int tamanoBarco, int idTipoBarco) {
        this.tipoBarco = tipoBarco;
        this.tamanoBarco = tamanoBarco;
        this.idTipoBarco = idTipoBarco;
    }

    /*Métodos Get y Set de la clase Barco.*/
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
