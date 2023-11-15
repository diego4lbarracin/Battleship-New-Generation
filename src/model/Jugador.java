package model;

import java.util.*;

public class Jugador extends Usuario{

    Tablero tableroOrigen;
    Tablero tableroObjetivo;
    private ArrayList<Barco> barcosJugador;
    public static Map<String, Integer> mapaLetraColumna = new HashMap<>();
    static {
        mapaLetraColumna.put("A", 0);
        mapaLetraColumna.put("B", 1);
        mapaLetraColumna.put("C", 2);
        mapaLetraColumna.put("D", 3);
        mapaLetraColumna.put("E", 4);
        mapaLetraColumna.put("F", 5);
        mapaLetraColumna.put("G", 6);
        mapaLetraColumna.put("H", 7);
        mapaLetraColumna.put("I", 8);
        mapaLetraColumna.put("J", 9);
    }

    public Jugador(String nombre, String documentoIdentidad, String alias, int numeroIntentos, Tablero tableroOrigen, Tablero tableroObjetivo) {
        super(nombre, documentoIdentidad, alias, numeroIntentos);
        this.tableroOrigen = tableroOrigen;
        this.tableroObjetivo = tableroObjetivo;
        this.barcosJugador = new ArrayList<Barco>();
        barcosJugador.add(new Barco("PORTAVIONES",5, 1));
        barcosJugador.add(new Barco("ACORAZADO",4, 2));
        barcosJugador.add(new Barco("ACORAZADO",4, 3));
        barcosJugador.add(new Barco("CRUCERO",1, 4));
        barcosJugador.add(new Barco("SUBMARINO",3, 5));
        barcosJugador.add(new Barco("SUBMARINO",3, 6));
        barcosJugador.add(new Barco("DESTRUCTOR",2, 7));
        barcosJugador.add(new Barco("DESTRUCTOR",2, 8));
        barcosJugador.add(new Barco("DESTRUCTOR",2, 9));
        barcosJugador.add(new Barco("DESTRUCTOR",2, 10));
    }

    public ArrayList<Barco> getBarcosJugador() {
        return barcosJugador;
    }

    public void setBarcosJugador(ArrayList<Barco> barcosJugador) {
        this.barcosJugador = barcosJugador;
    }

    public int obtenerColumna(String valorColumna){
        /*Method to convert a string into the corresponding value in the columns.*/
        return Jugador.mapaLetraColumna.get(valorColumna);
    }

    public int obtenerFila(String valorFila){
        /*Method to convert a string into the corresponding value in the rows.*/
        return Integer.parseInt(valorFila) - 1;
    }

    public boolean calculoDistanciaTamanoBarco(int x1, int x2, int y1, int y2, int tamanoBarco){
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        if ( tamanoBarco == ( Math.floor(distance) + 1 ) ){
            return true;
        }else{
            return false;
        }
    }
    public void ubicarBarcosJugador(){
        System.out.println("SECUENCIA DE UBICACION DE BARCOS");
        System.out.println("Ingrese la coordenada de la siguiente manera -> \"E6\".");
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        String coordenada1;
        String coordenada2;
        Scanner sc= new Scanner(System.in);
        for (Barco i:
             this.barcosJugador) {
            System.out.println("Tipo de Barco -> "+ i.getTipoBarco()+", "+"Tamano Barco -> "+i.getTamanoBarco());
            System.out.println("ID Tipo Barco -> "+i.getIdTipoBarco());
            boolean registroBarcoExitoso = true;
            do {
                int xInicial, yInicial;
                int xFinal, yFinal;
                Boolean correcta = false;
                do {
                    System.out.print("Ingrese la coordenada inicial -> ");
                    coordenada1 = sc.nextLine();
                    System.out.print("Ingrese la coordenada final -> ");
                    coordenada2 = sc.nextLine();
                    xInicial = obtenerColumna(coordenada1.substring(0, 1));
                    yInicial = obtenerFila(coordenada1.substring(1));

                    xFinal = obtenerColumna(coordenada2.substring(0, 1));
                    yFinal = obtenerFila(coordenada2.substring(1));

                    /*Para ver si funciona*/
//                    System.out.println("xInicial: "+ xInicial);
//                    System.out.println("yInicial: "+ yInicial);
//                    System.out.println("xFinal: "+ xFinal);
//                    System.out.println("yFinal: "+ yFinal);
                    correcta = calculoDistanciaTamanoBarco(xInicial, xFinal, yInicial, yFinal, i.getTamanoBarco());
                    if(!correcta){
                        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                        System.out.println("Coordenada Invalida.");
                        System.out.println("Ingrese una coordenada nuevamente.");
                        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                    }
                } while (!correcta);
//                String idBarco = Integer.toString(i.getIdTipoBarco());
//                System.out.println("idBarco: "+idBarco);
//                tableroOrigen.imprimirTablero();
                for (int j = yInicial; j <= yFinal; j++) {
                    for (int k = xInicial; k <= xFinal; k++) {
                       if (tableroOrigen.tablero[j][k].equals("_") ) {
                           tableroOrigen.tablero[j][k] = Integer.toString(i.getIdTipoBarco());
                       }else{
                           System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                           System.out.println("No se puede insertar este barco en estas posiciones.");
                           System.out.println("Siga las instrucciones e inserte su barco nuevamente.");
                           System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");

                           registroBarcoExitoso = false;
                       }
                    }
                }
                tableroOrigen.imprimirTablero();

            }while (!registroBarcoExitoso);

        }
    }
    public void eliminarBarco(int idTipoBarco){
        barcosJugador.removeIf( b -> b.getIdTipoBarco()==idTipoBarco);
    }
    public void atacarComputadora(String coordenadaDeAtaque, String mensaje){
        int x= Jugador.mapaLetraColumna.get(coordenadaDeAtaque.substring(0, 1));
        int y= Integer.parseInt(coordenadaDeAtaque.substring(1))-1;
        switch (mensaje){
            case "IMPACTADO", "HUNDIDO" -> {
                tableroObjetivo.tablero[y][x] = "/";
            }
            case "AL AGUA" -> {
                tableroObjetivo.tablero[y][x] = "X";
            }
        }
    }

}
