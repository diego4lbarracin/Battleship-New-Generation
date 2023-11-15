package model;

import java.util.Random;

public class Computadora extends Usuario{
    Tablero tableroComputadora;
    private int numeroBarcos;
    public Computadora(String nombre, String documentoIdentidad, String alias, Tablero tableroComputadora, int numeroIntentos
    ,int numeroBarcos) {
        super(nombre, documentoIdentidad, alias, numeroIntentos);
        this.tableroComputadora = tableroComputadora;
        this.numeroBarcos = numeroBarcos;
    }

    public int getNumeroBarcos() {
        return numeroBarcos;
    }

    public void setNumeroBarcos(int numeroBarcos) {
        this.numeroBarcos -= numeroBarcos;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }


    public int atacarJugador(){
        Random rand = new Random();
        return rand.nextInt(10);
    }
    public void ubicarBarcosComputadora(){
//        Random rand = new Random();
//        int opcion = rand.nextInt(100);
        switch (1){
            case 1 -> {
                /*Submarino*/
                for (int i = 4; i <=8 ; i++) {
                    tableroComputadora.tablero[0][i] = "1";
                }
                /*Acorazado1*/
                for (int i = 6; i <=9 ; i++) {
                    tableroComputadora.tablero[2][i] = "2";
                }
                /*Acorazado2*/
                for (int i = 0; i <= 3 ; i++) {
                    tableroComputadora.tablero[i][0] = "3";
                }
                /*Crucero*/
                tableroComputadora.tablero[2][2] = "4";
                /*Submarino1*/
                for (int i = 2; i <= 4 ; i++) {
                    tableroComputadora.tablero[5][i] = "5";
                }
                /*Submarino 2*/
                for (int i = 6; i <= 8 ; i++) {
                    tableroComputadora.tablero[5][i] = "6";
                }
                /*Destructor 1*/
                for (int i = 2; i <= 3 ; i++) {
                    tableroComputadora.tablero[i][4] = "7";
                }
                /*Destructor 2*/
                for (int i = 7; i <= 8 ; i++) {
                    tableroComputadora.tablero[i][1] = "8";
                }
                /*Destructor 3*/
                for (int i = 7; i <= 8 ; i++) {
                    tableroComputadora.tablero[i][4] = "9";
                }
                /*Destructor 3*/
                for (int i = 7; i <= 8 ; i++) {
                    tableroComputadora.tablero[i][7] = "10";
                }

            }
        }
    }
}
