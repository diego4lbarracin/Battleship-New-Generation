package model;
import java.util.Random;
/*CLASE COMPUTADORA: La clase computadora corresponde a una especialización de la clase Usuario. La clase incorpora métodos
* diferentes correspondientes a un Usuario de este tipo. La computadora corresponde a otro tipo de jugador y será el enemigo
* de los jugadores reales.*/
public class Computadora extends Usuario{
    /*Atributos de la clase Computadora*/
    private int numeroBarcos;

    /*Método Constructor de la clase Computadora*/
    public Computadora(String nombre, String documentoIdentidad, String alias, Tablero tableroOrigen, Tablero tableroObjetivo, int numeroIntentos
    ,int numeroBarcos) {
        /*Método constructor de la superclase*/
        super(nombre, documentoIdentidad, alias, numeroIntentos, tableroOrigen, tableroObjetivo);
        this.numeroBarcos = numeroBarcos;
    }

    /*Métodos Get y Set de la clase.*/

    public int getNumeroBarcos() {
        return numeroBarcos;
    }

    public void setNumeroBarcos(int numeroBarcos) {
        this.numeroBarcos += numeroBarcos;
    }

    /*Métodos propios de la clase.*/
    public int atacarJugador(){
        /*Método atacarJugador: Ese método retorna un número aleatorio en el rango de 1 a 10.
        * Este método será inicializado para instancia las coordenadas de ataque de la computadora
        * y evaluarlas en el tablero de Origen en un objeto de la clase Jugador.*/
        Random rand = new Random();
        return rand.nextInt(10);
    }
    public void ubicarBarcosComputadora(){
        /*Método ubicarBarcosComputadora: Ese método se encarga de ubicar los barcos en el tablero de la computadora.
        * Para hacerlo, se genera un número aleatorio en el rango de 1 a 100 y luego se envía un switch() el cual se
        * encargará de llevar al programa a cada uno de los 100 diferentes casos para la ubicación de los barcos.*/

//        Random rand = new Random();
//        int opcion = rand.nextInt(100);
        /*Por el momento, solo hay 1 caso.*/
        switch (1){
            case 1 -> {
                /*Submarino*/
                for (int i = 4; i <=8 ; i++) {
                    tableroOrigen.getTablero()[0][i] = "1";
                }
                /*Acorazado1*/
                for (int i = 6; i <=9 ; i++) {
                    tableroOrigen.getTablero()[2][i] = "2";
                }
                /*Acorazado2*/
                for (int i = 0; i <= 3 ; i++) {
                    tableroOrigen.getTablero()[i][0] = "3";
                }
                /*Crucero*/
                tableroOrigen.getTablero()[2][2] = "4";
                /*Submarino1*/
                for (int i = 2; i <= 4 ; i++) {
                    tableroOrigen.getTablero()[5][i] = "5";
                }
                /*Submarino 2*/
                for (int i = 6; i <= 8 ; i++) {
                    tableroOrigen.getTablero()[5][i] = "6";
                }
                /*Destructor 1*/
                for (int i = 2; i <= 3 ; i++) {
                    tableroOrigen.getTablero()[i][4] = "7";
                }
                /*Destructor 2*/
                for (int i = 7; i <= 8 ; i++) {
                    tableroOrigen.getTablero()[i][1] = "8";
                }
                /*Destructor 3*/
                for (int i = 7; i <= 8 ; i++) {
                    tableroOrigen.getTablero()[i][4] = "9";
                }
                /*Destructor 3*/
                for (int i = 7; i <= 8 ; i++) {
                    tableroOrigen.getTablero()[i][7] = "10";
                }

            }
        }
    }
}
