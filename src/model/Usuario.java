package model;
/*CLASE USUARIO: Clase abstracta la cual permite la generalización de muchos
* los comportamientos compartidos por los dos tipos de jugadores, el jugador real,
* y el jugador sistema.*/
public abstract class Usuario{
    /*Atributos de la clase Usuario*/
    protected String nombre;
    protected String documentoIdentidad;
    protected String alias;
    protected int numeroIntentos;
    protected int puntuacion;
    protected Tablero tableroOrigen; /*Para registrar los barcos del jugador.*/
    protected Tablero tableroObjetivo; /*Para registrar las posiciones que ataca un jugador.*/
    /*Método constructor para la clase Usuario.*/
    public Usuario(String nombre, String documentoIdentidad, String alias, int numeroIntentos, Tablero tableroOrigen, Tablero tableroObjetivo) {
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.alias = alias;
        this.numeroIntentos = numeroIntentos;
        this.tableroOrigen = tableroOrigen;
        this.tableroObjetivo = tableroObjetivo;
    }

    /*Métodos Get y Set para modificar y obtener la información de cada atributo de un
    * objeto de la clase.*/

    public Tablero getTableroOrigen() {
        return tableroOrigen;
    }

    public void setTableroOrigen(Tablero tableroOrigen) {
        this.tableroOrigen = tableroOrigen;
    }

    public Tablero getTableroObjetivo() {
        return tableroObjetivo;
    }

    public void setTableroObjetivo(Tablero tableroObjetivo) {
        this.tableroObjetivo = tableroObjetivo;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        /*Este método ha sido modificado para que cada vez que se haga uso del mismo, en lugar de actualizar
        * su información, se sume el valor obtenido por parámetro al valor actual dentro del atributo puntuación.*/
        this.puntuacion += puntuacion;

    }

    public int getNumeroIntentos() {
        return numeroIntentos;
    }

    public void setNumeroIntentos(int numeroIntentos) {
        /*Este método ha sido modificado para que cada vez que se haga uso del mismo, en lugar de actualizar
         * su información, se sume el valor obtenido por parámetro al valor actual dentro del atributo numeroIntentos.*/
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
