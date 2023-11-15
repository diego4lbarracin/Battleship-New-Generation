package model;

public class Tablero {
    String [][] tablero;

    public Tablero() {
        this.tablero = new String[10][10];
        /*Initializing the 2D array of type "char" with empty spaces.*/
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                tablero[i][j]= "  ";
            }
        }
    }

//    public char[][] getTablero() {
//        return tablero;
//    }
//
//    public void setTablero(char[][] tablero) {
//        this.tablero = tablero;
//    }

    public void imprimirTablero(){
        /*Function to print the 2D array in the given format.
        * Columns denoted from A to J, Rows denoted from 1 to 10.*/
        System.out.println("+---+---+---+---+---+---+---+---+---+---+---+");
        System.out.println("|   | A | B | C | D | E | F | G | H | I | J |");
        System.out.println("+---+---+---+---+---+---+---+---+---+---+---+");
        for (int i=0; i<10; i++){
            switch (i) {
                case 0 -> {
                    System.out.print("| 1 |");
                    for (int j = 0; j < 10; j++) {
                        System.out.print(tablero[i][j] + " |");
                    }
                    System.out.println();
                }
                case 1 -> {
                    System.out.print("| 2 |");
                    for (int j = 0; j < 10; j++) {
                        System.out.print(tablero[i][j] + " |");
                    }
                    System.out.println();
                }
                case 2 -> {
                    System.out.print("| 3 |");
                    for (int j = 0; j < 10; j++) {
                        System.out.print(tablero[i][j] + " |");
                    }
                    System.out.println();
                }
                case 3 -> {
                    System.out.print("| 4 |");
                    for (int j = 0; j < 10; j++) {
                        System.out.print(tablero[i][j] + " |");
                    }
                    System.out.println();
                }
                case 4 -> {
                    System.out.print("| 5 |");
                    for (int j = 0; j < 10; j++) {
                        System.out.print(tablero[i][j] + " |");
                    }
                    System.out.println();
                }
                case 5 -> {
                    System.out.print("| 6 |");
                    for (int j = 0; j < 10; j++) {
                        System.out.print(tablero[i][j] + " |");
                    }
                    System.out.println();
                }
                case 6 -> {
                    System.out.print("| 7 |");
                    for (int j = 0; j < 10; j++) {
                        System.out.print(tablero[i][j] + " |");
                    }
                    System.out.println();
                }
                case 7 -> {
                    System.out.print("| 8 |");
                    for (int j = 0; j < 10; j++) {
                        System.out.print(tablero[i][j] + " |");
                    }
                    System.out.println();
                }
                case 8 -> {
                    System.out.print("| 9 |");
                    for (int j = 0; j < 10; j++) {
                        System.out.print(tablero[i][j] + " |");
                    }
                    System.out.println();
                }
                case 9 -> {
                    System.out.print("|10 |");
                    for (int j = 0; j < 10; j++) {
                        System.out.print(tablero[i][j] + " |");

                    }
                    System.out.println();
                }
            }
            System.out.println("+---+---+---+---+---+---+---+---+---+---+---+");
        }
    }
}
