package model;

public abstract class Usuario{
    protected String nombre;
    protected String documentoIdentidad;
    protected String alias;
    protected int numeroIntentos;

    public Usuario(String nombre, String documentoIdentidad, String alias, int numeroIntentos) {
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.alias = alias;
        this.numeroIntentos = numeroIntentos;
    }

    public int getNumeroIntentos() {
        return numeroIntentos;
    }

    public void setNumeroIntentos(int numeroIntentos) {
        this.numeroIntentos += numeroIntentos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
