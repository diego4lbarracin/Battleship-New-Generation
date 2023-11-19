package model;

import java.util.*;
/*Clase COMPETENCIA: La clase competencia contiene métodos y atributos necesarios para la inicialización de una competencia.*/
public class Competencia {
    /*Atributos de la clase Competencia.*/
    private Computadora computadora;
    private ArrayList<Usuario> listaJugadores;
    private Boolean enCurso; /*enCurso: Variable que será usada para verificar que la competencia está activa o inactiva.*/

    /*Método constructor de la clase Competencia.*/
    public Competencia(Computadora computadora, ArrayList<Usuario> listaJugadores) {
        this.computadora = computadora;
        computadora.ubicarBarcosComputadora();
        this.listaJugadores = listaJugadores;
        this.enCurso = true;
    }
    /*Métodos de la clase*/
    public void secuenciaDeTurnosDeJuego(){
        /*Método secuenciaDeTurnosDeJuego: El método se encarga de la lógica para el control de los turnos de una partida.*/
        System.out.println("¡Que Comience el Juego!");
        System.out.println("-------------SECUENCIA DE TURNOS DE JUEGO------------");
        System.out.println("-----------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        Jugador jugadorActualLista = null;
        /*Los jugadores podrán interactuar mientras la variable enCurso == true.*/
        while (enCurso){
            /*Se itera la lista de jugadores*/
            for (Usuario j:
                    listaJugadores) {
                if (j instanceof Jugador) {
                    /*Si el objeto en la posición actual de la lista es una instancia de Jugador, entonces
                    * se realiza la conversión de ese objeto a Jugador para poder acceder los métodos especiales
                    * dentro de la clase Jugador.*/
                    jugadorActualLista = (Jugador) j;
                }
                /*ATAQUE DEL JUGADOR*/
                System.out.println("Alias Jugador -> " + j.getAlias());
                System.out.print("Ingrese la coordenada de ataque -> ");
                String coordenada = sc.nextLine().toUpperCase();
                /*Variable que almacena el retorno del resultado del ataque de un Jugador.*/
                System.out.println("Resultado Ataque -> " + mensajeResultadoAtaqueJugador(coordenada, jugadorActualLista) );
                System.out.println("Puntuacion Actual -> "+ jugadorActualLista.getPuntuacion() );
                jugadorActualLista.setNumeroIntentos(1);
                System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                /*ATAQUE DEL COMPUTADOR*/
                System.out.println("Alias Jugador -> " + computadora.getAlias());
                /*Impresión del mensaje del resultado de ataque del Computador.*/
                System.out.println("Resultado Ataque -> " + mensajeResultadoAtaqueComputadora(computadora.atacarJugador(), computadora.atacarJugador(), jugadorActualLista));
                System.out.println("Puntuacion Actual -> "+ computadora.getPuntuacion() );
                /*Se actualiza el número de intentos del computador.*/
                computadora.setNumeroIntentos(1);
                System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                /*IMPRESION DE LOS TABLEROS DEL JUGADOR*/
                System.out.println("TABLERO OBJETIVO JUGADOR -> " + jugadorActualLista.getAlias());
                jugadorActualLista.getTableroObjetivo().imprimirTablero();
                System.out.println("TABLERO ORIGEN JUGADOR -> " + jugadorActualLista.getAlias());
                jugadorActualLista.getTableroOrigen().imprimirTablero();
                /*La variable enCurso = al retorno del método revisarSiElJuegoContinua()*/
                enCurso = revisarSiElJuegoContinua(computadora, jugadorActualLista);
                System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                if (!enCurso) {
                    /*Si enCurso = false, entonces la partida habrá terminado.*/
                    System.out.println("La partida en curso ha terminado.");
                    break;
                }
            }
        }
    }
    public boolean revisarSiElJuegoContinua(Computadora c, Jugador jActual){
        /*Método revisarSiElJuegoContinua: Se encarga de evaluar si el número de barcos del computador es mayor a 0*/
        return c.getNumeroBarcos() > 0 && jActual.getBarcosJugador().size() > 0;
    }
    public String mensajeResultadoAtaqueComputadora(int x, int y, Jugador jActual){
        /*Método mensajeResultadoAtaqueComputadora: El método contiene la lógica de un ataque de la Computadora al jugador Actual.*/
        /*Variables necesarias.*/
        String mensaje = null;
        /*Almacena la información dentro de la posición a atacar.*/
        String elemento = jActual.getTableroOrigen().getTablero()[y][x];
        int contador=0;
        if (!Objects.equals(jActual.getTableroOrigen().getTablero()[y][x], "_")){
            /*Si el objeto dentro de la posición a atacar es igual a "_", entonces se procede a evaluar las siguientes condiciones..*/
            if (jActual.getTableroOrigen().getTablero()[y][x].equals("*") ||jActual.getTableroOrigen().getTablero()[y][x].equals("X")){
                /*Si el objeto dentro de la posición a atacar contiene un "*" o una "X", entonces se retorna "FRACASADO".*/
                System.out.println("Esta coordenada ya fue atacada antes.");
                mensaje = "FRACASADO";
                computadora.setPuntuacion(-1);
            }else{
                /*Si el objeto dentro de la posición a atacar NO contiene un "*" o una "X", entonces se marca esa posición como atacada
                y se itera sobre todo el tablero del jugador para probar si ya no existen más elementos iguales a los que habían dentro
                * de esa posición del tablero. */
                jActual.getTableroOrigen().getTablero()[y][x]= "*";

                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (jActual.getTableroOrigen().getTablero()[i][j].equals(elemento)){
                            /*Si se encuentra un elemento igual, se suma 1 al contador.*/
                            contador+=1;
                            break;
                        }
                    }
                }
                if (contador==0){
                    /*Si el contador es == 0, es porque el barco ya ha sido destruido.*/
                    mensaje = "HUNDIDO";
                    /*Se elimina el Barco de la lista de barcos del jugador usando el ID del barco, el
                    * cual se encuentra almacenado dentro de la variable elemento.*/
                    int toRemove= Integer.parseInt(elemento);
                    jActual.eliminarBarco(toRemove);
                    /*Se le suman 4 puntos a la Computadora.*/
                    computadora.setPuntuacion(4);

                }else{
                    /*Si el contador no es 0, entonces fue porque solo se impactó un barco.*/
                    mensaje = "IMPACTADO";
                    /*Se le suman 2 puntos a la Computadora*/
                    computadora.setPuntuacion(2);
                }
            }
        } else if (jActual.getTableroOrigen().getTablero()[y][x].equals("_")) {
            /*Si el objeto dentro de la posición a atacar es igual a "_", entonces el mensaje será "AL AGUA"
            y se marcara esa posición como "X".*/
            mensaje = "AL AGUA";
            jActual.getTableroOrigen().getTablero()[y][x] = "X";
            /*Se resta -1 punto a la puntuación total de la computadora.*/
            computadora.setPuntuacion(-1);
        }
        /*Se realiza el retorno del mensaje según corresponda, "HUNDIDO", "AL AGUA", "IMPACTADO"*/
        return mensaje;
    }
    public String mensajeResultadoAtaqueJugador(String coordenadaDeAtaque, Jugador jActual){
        /*Método mensajeResultadoAtaqueJugador: Método que retorna el mensaje del resultado del ataque de un Jugador a la computadora.
        * La lógica es igual a la lógica empleada dentro del método mensajeResultadoAtaqueComputador.*/
        String mensaje = null;
        int contador=0;
        int x= Jugador.mapaLetraColumna.get(coordenadaDeAtaque.substring(0, 1));
        int y= Integer.parseInt(coordenadaDeAtaque.substring(1)) - 1;

        String elemento = computadora.getTableroOrigen().getTablero()[y][x];

        if (!Objects.equals(computadora.getTableroOrigen().getTablero()[y][x], "_")){
            if (computadora.getTableroOrigen().getTablero()[y][x].equals("*") || computadora.getTableroOrigen().getTablero()[y][x].equals("X")){
                System.out.println("Esta coordenada ya fue atacada antes.");
                mensaje = "FRACASADO";
                jActual.setPuntuacion(-1);
            }else{
                computadora.getTableroOrigen().getTablero()[y][x]= "*";

                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (computadora.getTableroOrigen().getTablero()[i][j].equals(elemento)){
                            contador+=1;
                        }
                    }
                }
                if (contador==0){
                    mensaje = "HUNDIDO";
                    computadora.setNumeroBarcos(-1);
                    jActual.setPuntuacion(4);
                }else{
                    mensaje = "IMPACTADO";
                    jActual.setPuntuacion(2);
                }
            }
        } else if (computadora.getTableroOrigen().getTablero()[y][x].equals("_")) {
            mensaje = "AL AGUA";
            jActual.setPuntuacion(-1);
        }

        jActual.atacarComputadora(coordenadaDeAtaque, mensaje);

        return mensaje;
    }
    public void ReporteCompetencia(){
        /*Método ReporteCompetencia: Método que se encarga de organizar la lista de resultados en orden descendente
        * usando como criterio la puntuación de cada participante y luego imprime los resultados.*/
        if(!enCurso){
            ArrayList<Usuario> listaResultados = listaJugadores;
            listaResultados.add(computadora);
            /*.sort(): Método de ArrayList para ordenar elementos "in_place" dentro de un ArrayList*/
            listaResultados.sort(Comparator.comparingInt(Usuario::getPuntuacion).reversed());
            System.out.println("-----------------------------------------------------");
            System.out.println("------------------*RESULTADOS FINALES*---------------");
            int i=1;
            /*Impresión de la tabla de resultados Finales.*/
            for (Usuario usuario: listaResultados){
                System.out.println("Puesto-> "+i+", Alias-> "+usuario.getAlias()+", Puntuacion-> "+usuario.getPuntuacion()+".");
                System.out.println("-----------------------------------------------------");
                i++;
            }

        }
    }
}
