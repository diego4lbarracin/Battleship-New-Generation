package model;
/*CLASE TABLERO: La clase tablero contiene un array de 2D de tipo String que corresponde al tablero de un jugador.
* La clase tablero también ofrece un método para la impresión del tablero siguiendo el formato del juego.*/
public class Tablero {
    /*Atributos de la clase Tablero.*/
    private String [][] tablero;

    /*Método constructor de la clase Tablero-*/
    public Tablero() {
        this.tablero = new String[10][10];
        /*Initializing the 2D array of type "char" with empty spaces.*/
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                tablero[i][j]= "_";
            }
        }
    }
    /*Métodos Get y Set de la clase.*/
    public String[][] getTablero() {
        return tablero;
    }

    public void setTablero(String[][] tablero) {
        this.tablero = tablero;
    }

    public void imprimirTablero(){
        /*Función para imprimir el tablero siguiendo el formato de juego.*/
        System.out.println("+---+---+---+---+---+---+---+---+---+---+---+");
        System.out.println("|   | A | B | C | D | E | F | G | H | I | J |");
        System.out.println("+---+---+---+---+---+---+---+---+---+---+---+");
        for (int i=0; i<10; i++){
            switch (i) {
                case 0 -> {
                    System.out.print("| 1 |");
                    for (int j = 0; j < 10; j++) {
                        if(tablero[i][j].equals("_")){
                            System.out.print(" "+" " + " |");
                        }else{
                            System.out.print(" "+tablero[i][j] + " |");
                        }
                    }
                    System.out.println();
                }
                case 1 -> {
                    System.out.print("| 2 |");
                    for (int j = 0; j < 10; j++) {
                        if(tablero[i][j].equals("_")){
                            System.out.print(" "+" " + " |");
                        }else{
                            System.out.print(" "+tablero[i][j] + " |");
                        }
                    }
                    System.out.println();
                }
                case 2 -> {
                    System.out.print("| 3 |");
                    for (int j = 0; j < 10; j++) {
                        if(tablero[i][j].equals("_")){
                            System.out.print(" "+" " + " |");
                        }else{
                            System.out.print(" "+tablero[i][j] + " |");
                        }
                    }
                    System.out.println();
                }
                case 3 -> {
                    System.out.print("| 4 |");
                    for (int j = 0; j < 10; j++) {
                        if(tablero[i][j].equals("_")){
                            System.out.print(" "+" " + " |");
                        }else{
                            System.out.print(" "+tablero[i][j] + " |");
                        }
                    }
                    System.out.println();
                }
                case 4 -> {
                    System.out.print("| 5 |");
                    for (int j = 0; j < 10; j++) {
                        if(tablero[i][j].equals("_")){
                            System.out.print(" "+" " + " |");
                        }else{
                            System.out.print(" "+tablero[i][j] + " |");
                        }
                    }
                    System.out.println();
                }
                case 5 -> {
                    System.out.print("| 6 |");
                    for (int j = 0; j < 10; j++) {
                        if(tablero[i][j].equals("_")){
                            System.out.print(" "+" " + " |");
                        }else{
                            System.out.print(" "+tablero[i][j] + " |");
                        }
                    }
                    System.out.println();
                }
                case 6 -> {
                    System.out.print("| 7 |");
                    for (int j = 0; j < 10; j++) {
                        if(tablero[i][j].equals("_")){
                            System.out.print(" "+" " + " |");
                        }else{
                            System.out.print(" "+tablero[i][j] + " |");
                        }
                    }
                    System.out.println();
                }
                case 7 -> {
                    System.out.print("| 8 |");
                    for (int j = 0; j < 10; j++) {
                        if(tablero[i][j].equals("_")){
                            System.out.print(" "+" " + " |");
                        }else{
                            System.out.print(" "+tablero[i][j] + " |");
                        }
                    }
                    System.out.println();
                }
                case 8 -> {
                    System.out.print("| 9 |");
                    for (int j = 0; j < 10; j++) {
                        if(tablero[i][j].equals("_")){
                            System.out.print(" "+" " + " |");
                        }else{
                            System.out.print(" "+tablero[i][j] + " |");
                        }
                    }
                    System.out.println();
                }
                case 9 -> {
                    System.out.print("|10 |");
                    for (int j = 0; j < 10; j++) {
                        if(tablero[i][j].equals("_")){
                            System.out.print(" "+" " + " |");
                        }else if (tablero[i][j].equals("10")){
                            System.out.print(tablero[i][j] + " |");
                        }else {
                            System.out.print(" "+tablero[i][j] + " |");
                        }
                    }
                    System.out.println();
                }
            }
            System.out.println("+---+---+---+---+---+---+---+---+---+---+---+");
        }
    }
}
