import view.GUITexto;

public class Main {
    public static void main(String[] args) {
//        String[][] tablero  = new   String[10][10];
//        for (int i=0; i<10; i++){
//            for (int j=0; j<10; j++){
//                tablero[i][j]= "  ";
//            }
//        }
//        int startX = 1, startY = 1;  // coordinates of the first position
//        int endX = 4, endY = 1;  // coordinates of the second position
//
//        double distance = Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
//        if( (distance+1) == 4 ){
//            for (int i=startY; i<=endY; i++){
//                for (int j=startX; j<=endX;j++){
//                    tablero[i][j] = " P";
//                }
//            }
//        }
////        for (int i = 0; i < 10; i++) {
////            for (int j = 0; j < 10; j++) {
////                System.out.print(tablero[i][j]+" | ");
////            }
////        }
////


//                double num = 123.45;
//
//                if (num == Math.floor(num)) {
//                    System.out.println("The number is not a floating point number");
//                } else {
//                    System.out.println("The number is a floating point number");
//                }
        GUITexto guiText = new GUITexto();
        guiText.interfazDeJuego();

    }
}