package model;
import java.util.*;

/*ClASE JUGADOR: La clase jugador corresponde a una especialización de la clase
* Usuario. Incorpora métodos y atributos especiales de un Jugador Real*/
public class Jugador extends Usuario{
    /*Atributos de la clase Jugador*/
    private Tablero tableroOrigen; /*Para registrar los barcos del jugador.*/
    private Tablero tableroObjetivo; /*Para registrar las posiciones que ataca un jugador.*/
    private ArrayList<Barco> barcosJugador;
    /*Atributo STATIC mapaLetraColumna: Para realizar la conversion de una coordenada
    * ingresada durante las secuencias de juego ("E6") a una coordenada válida de una
    * matriz. Cada letra del alfabeto desde la "A" a la "J" tiene asociado su valor en la
    * matriz.*/
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
    /*Metodo Constructor de la clase Jugador.*/
    public Jugador(String nombre, String documentoIdentidad, String alias, int numeroIntentos, Tablero tableroOrigen, Tablero tableroObjetivo) {
        /*Atributos correspondientes al constructor de la superclase.*/
        super(nombre, documentoIdentidad, alias, numeroIntentos);
        this.tableroOrigen = tableroOrigen;
        this.tableroObjetivo = tableroObjetivo;
        this.barcosJugador = new ArrayList<Barco>();
        /*Instanciando y añadiendo barcos a la lista de barcos asociados a un jugador. Son 10
        * barcos del tipo de barcos ingresados en la lista. El id de cada tipo de barco será usado
        * en las mecanicas de juego para identificar si se destruyo completamente un barco.*/
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
    /*Metodos Get y Set de los atributos de la clase.*/
    public ArrayList<Barco> getBarcosJugador() {
        return barcosJugador;
    }

    public void setBarcosJugador(ArrayList<Barco> barcosJugador) {
        this.barcosJugador = barcosJugador;
    }

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

    /*Métodos de la clase.*/

    public int obtenerColumna(String valorColumna){
        /*Método obtenerColumna: Método para convertir la coordenada en cuyo valor es de tipo string a su
        correspondiente valor en las columnas de la matriz. Este proceso se logra por medio del
        mapaLetraColumna, el cual es un atributo static de la clase Jugador.*/
        return Jugador.mapaLetraColumna.get(valorColumna);
    }

    public int obtenerFila(String valorFila){
        /*Método obtenerFila: para convertir la coordenada cuyo valor es de tipo string a su correspondiente
        * valor en las filas cuyo valor debe ser de tipo int. Al valor se le resta 1 debido a que
        * los índices van de 0 a N-1 y no de 1 a N. */
        return Integer.parseInt(valorFila) - 1;
    }

    public boolean calculoDistanciaTamanoBarco(int x1, int x2, int y1, int y2, int tamanoBarco){
        /*Método calculoDistanciaTamanoBarco: Método para obtener la distancia entre 2 coordenadas en el tablero de juego del jugador. Para
        * calcular la distancia en el tablero de juego, el cual es un array de 2 dimensiones se utiliza la
        * fórmula de la distancia euclidiana. Este método se usa para evaluar que, a la hora de que un jugador
        * se encuentra ubicando sus barcos en su tablero, no ingrese coordinates inválidas en función del tamaño del
        * barco que está ubicando en el tablero.*/
        double distance = Math.sqrt(Math.pow( Math.abs(x2 - x1), 2) + Math.pow( Math.abs(y2 - y1), 2));
        /*Si la distancia entre las dos coordenadas es igual al tamaño del barco que se quiere ubicar, se retorna true.*/
        return tamanoBarco == (Math.floor(distance) + 1);
    }
    public void ubicarBarcosJugador(){
        /*Método ubicarBarcosJugador: Método que contiene la secuencia para la ubicación de barcos en el tablero
        * por parte de un jugador. */
        System.out.println("----------SECUENCIA DE UBICACION DE BARCOS----------");
        System.out.println("Ingrese la coordenada de la siguiente manera -> \"E6\".");
        System.out.println("-----------------------------------------------------");
        String coordenada1;
        String coordenada2;
        Scanner sc= new Scanner(System.in);
        /*La secuencia de ubicación de barcos se va a repetir según el número de elementos dentro de la lista de barcos.
        Se itera sobre los elementos dentro de la lista de Barcos del jugador.*/
        for (Barco i : this.barcosJugador) {
            /*Impresión del nombre del tipo de barco, su tamaño y su ID*/
            System.out.println("Tipo de Barco -> "+ i.getTipoBarco()+", "+"Tamano Barco -> "+i.getTamanoBarco());
            System.out.println("ID Tipo Barco -> "+i.getIdTipoBarco());
            /*La variable registroBarcoExitoso = true para el control del ingreso de barcos al tablero, si el registro de
            * un barco no fue exitoso, se itera la siguiente secuencia hasta que las condiciones para el registro de un barco
            * se cumplan.*/
            boolean registroBarcoExitoso = true;
            do {
                /*Variables para almacenar las coordenadas que se usaran para insertar los barcos en el tablero.*/
                int xInicial, yInicial;
                int xFinal, yFinal;
                /*Variable correcta: Se inicializa como false con el objetivo de evaluar que las coordenadas ingresadas son correctas.*/
                boolean correcta=false;
                do {
                    System.out.print("Ingrese la coordenada inicial -> ");
                    coordenada1 = sc.nextLine().toUpperCase();
                    System.out.print("Ingrese la coordenada final -> ");
                    coordenada2 = sc.nextLine().toUpperCase();
                    /*El retorno de la función obtenerColumna será almacenado en la variable xInicial*/
                    xInicial = obtenerColumna(coordenada1.substring(0, 1));
                    /*El retorno de la función obtenerFila será almacenado en la variable xInicial*/
                    yInicial = obtenerFila(coordenada1.substring(1));
                    /*El retorno de la función obtenerColumna será almacenado en la variable xFinal*/
                    xFinal = obtenerColumna(coordenada2.substring(0, 1));
                    /*El retorno de la función obtenerFila será almacenado en la variable yFinal*/
                    yFinal = obtenerFila(coordenada2.substring(1));

                    /*El retorno de la función calculoDistanciaTamanoBarco será almacenado en la variable correcta*/
                    correcta = calculoDistanciaTamanoBarco(xInicial, xFinal, yInicial, yFinal, i.getTamanoBarco());
                    if(!correcta){
                        /*Si el resultado dentro de correcta == false, significa que las variables ingresadas
                        * no son correctas y tendrán que ser ingresadas nuevamente.*/
                        System.out.println("-----------------------------------------------------");
                        System.out.println("Coordenada Invalida.");
                        System.out.println("Ingrese una coordenada nuevamente.");
                        System.out.println("-----------------------------------------------------");
                    }
                } while (!correcta);

                /*FOR LOOPS que se encargan de iterar sobre las coordenadas ingresadas por el jugador. Con
                * estas coordenadas, se mueve dentro del tablero de juego e inserta el tipo de barco correspondientes
                * en las posiciones indicadas.*/

                /*Manejo para la inserción de posiciones como G3-G1 o I1-E1*/
                if( (yFinal > yInicial || yFinal == yInicial) && (xFinal > xInicial || xFinal == xInicial) ){
                    for (int j = yInicial; j <= yFinal; j++) {
                        for (int k = xInicial; k <= xFinal; k++) {
                            /*Si las coordenadas dentro del tablero se encuentran marcadas como espacios vacios, entonces
                             * se procede a ubicar el barco.*/
                            if (tableroOrigen.getTablero()[j][k].equals("_") ) {
                                /*Convirtiendo el ID del tipo de barco a String.*/
                                tableroOrigen.getTablero()[j][k] = Integer.toString(i.getIdTipoBarco());
                            }else{
                                /*Si las coordenadas dentro del tablero ya contienen información, entonces el registro del marco
                                 * se marca como no exitoso. (registroBarcoExitoso = false).*/
                                System.out.println("-----------------------------------------------------");
                                System.out.println("No se puede insertar este barco en estas posiciones.");
                                System.out.println("Siga las instrucciones e inserte su barco nuevamente.");
                                System.out.println("-----------------------------------------------------");
                                registroBarcoExitoso = false;
                            }
                        }
                    }
                }else{
                    for (int j = yInicial; j >= yFinal; j--) {
                        for (int k = xInicial; k >= xFinal; k--) {
                            /*Si las coordenadas dentro del tablero se encuentran marcadas como espacios vacios, entonces
                             * se procede a ubicar el barco.*/
                            if (tableroOrigen.getTablero()[j][k].equals("_") ) {
                                /*Convirtiendo el ID del tipo de barco a String.*/
                                tableroOrigen.getTablero()[j][k] = Integer.toString(i.getIdTipoBarco());
                            }else{
                                /*Si las coordenadas dentro del tablero ya contienen información, entonces el registro del marco
                                 * se marca como no exitoso. (registroBarcoExitoso = false).*/
                                System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                                System.out.println("No se puede insertar este barco en estas posiciones.");
                                System.out.println("Siga las instrucciones e inserte su barco nuevamente.");
                                System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");

                                registroBarcoExitoso = false;
                            }
                        }
                    }
                }

                /*Se imprime el tablero del jugador, independientemente de que si el registroBarcoExitoso = true o
                * registroBarcoExitoso = false*/
                tableroOrigen.imprimirTablero();
            /*La anterior secuencia se va a repetir mientras el registro de un barco no sea exitoso.*/
            }while (!registroBarcoExitoso);
            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        }
    }
    public void eliminarBarco(int idTipoBarco){
        /*Método eliminarBarco: El método elimina un barco de la lista de barcos según
        * un ID de barco.*/
        barcosJugador.removeIf( b -> b.getIdTipoBarco()==idTipoBarco);
    }
    public void atacarComputadora(String coordenadaDeAtaque, String mensajeResultadoAtaque){
        /*Método atacarComputadora: El método se encarga de, por medio de una coordenada de ataque ingresada
        * por un jugador, realiza el registro de la coordenada dentro del tablerObjetivo. El valor insertado va a estar dado
        * por el mensaje obtenido por parámetro.*/
        /*Convirtiendo la coordenada a un valor válido para un array de 2D haciendo uso del atributo static mapaLetraColumna y la conversión
        * de un String a un valor int.*/
        int x= Jugador.mapaLetraColumna.get(coordenadaDeAtaque.substring(0, 1));
        int y= Integer.parseInt(coordenadaDeAtaque.substring(1))-1;

        switch (mensajeResultadoAtaque){
            case "IMPACTADO", "HUNDIDO" -> {
                /*Si el mensaje del resultado del ataque es igual a "IMPACTADO", "HUNDIDO", entonces
                * se inserta un "/" al tablero objetivo del jugador.*/
                tableroObjetivo.getTablero()[y][x] = "/";

            }
            case "AL AGUA" -> {
                /*Si el mensaje del resultado del ataque es igual a "AL AGUA", entonces
                 * se inserta un "X" al tablero objetivo del jugador.*/
                tableroObjetivo.getTablero()[y][x] = "X";
            }
        }
    }

}
