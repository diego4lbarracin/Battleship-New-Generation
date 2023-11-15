package model;

import javax.sound.midi.Soundbank;
import java.util.*;

public class Competencia {
    private Computadora computadora;
    private ArrayList<Usuario> listaJugadores;
    private Boolean enCurso;

    public Competencia(Computadora computadora, ArrayList<Usuario> listaJugadores) {
        this.computadora = computadora;
        this.listaJugadores = listaJugadores;
        this.enCurso = true;
    }

    public void secuenciaDeTurnosDeJuego(){
        Scanner sc = new Scanner(System.in);
        Jugador jugadorActualLista = null;
        while (enCurso){
            for (Usuario j: listaJugadores) {
                if (j instanceof Jugador) {
                    jugadorActualLista = (Jugador) j;
                }
                /*ATAQUE DEL JUGADOR*/
                System.out.println("Alias Jugador -> " + j.getAlias());
                System.out.println("Ingrese la coordenada de ataque -> ");
                String coordenada = sc.nextLine();
                String mensajeAtaqueJugador = mensajeResultadoAtaqueJugador(coordenada);
                System.out.println("Resultado Ataque -> " + mensajeAtaqueJugador);
                jugadorActualLista.atacarComputadora(coordenada, mensajeAtaqueJugador);
                jugadorActualLista.setNumeroIntentos(1);
                /*ATAQUE DEL COMPUTADOR*/
                System.out.println("Alias Jugador -> " + computadora.getAlias());
                int x = computadora.atacarJugador(), y = computadora.atacarJugador();
                System.out.println("Resultado Ataque -> " + mensajeResultadoAtaqueComputadora(x, y, jugadorActualLista));
                computadora.setNumeroIntentos(1);
                /*IMPRESION DE LOS TABLEROS DEL JUGADOR*/
                System.out.println("TABLERO OBJETIVO JUGADOR -> " + jugadorActualLista.getAlias());
                jugadorActualLista.tableroObjetivo.imprimirTablero();
                System.out.println("TABLERO ORIGEN JUGADOR -> " + jugadorActualLista.getAlias());
                jugadorActualLista.tableroOrigen.imprimirTablero();
                enCurso = revisarSiElJuegoContinua(computadora, jugadorActualLista);
                if (!enCurso) {
                    System.out.println("La partida en curso ha terminado.");
                    break;
                }
            }
        }
    }
    public boolean revisarSiElJuegoContinua(Computadora c, Jugador jActual){
        boolean continua = false;
        if (c.getNumeroBarcos()>0){
            continua = true;
        }
        if (jActual.getBarcosJugador().size() > 0){
            continua=true;
        }
        return continua;
    }
    public String mensajeResultadoAtaqueComputadora(int x, int y, Jugador jActual){
        String mensaje = null;
        if (!Objects.equals(jActual.tableroOrigen.tablero[y][x], "  ")){
            String elemento = jActual.tableroOrigen.tablero[y][x];
            if (elemento.equals(" *") || elemento.equals(" X")){
                System.out.println("Esta coordenada ya fue atacada antes.");
                mensaje = "FRACASADO";
            }else{
                jActual.tableroOrigen.tablero[y][x]= " *";
                int contador=0;
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (jActual.tableroOrigen.tablero[i][j].equals(elemento)){
                            contador+=1;
                        }
                    }
                }
                if (contador==0){
                    mensaje = "HUNDIDO";
                    int toRemove= Integer.parseInt(elemento);
                    jActual.eliminarBarco(toRemove);
                }else{
                    mensaje = "IMPACTADO";
                }
            }
        } else if (jActual.tableroOrigen.tablero[y][x].equals("  ")) {
            mensaje = "AL AGUA";
            jActual.tableroOrigen.tablero[y][x] = " X";
        }
        return mensaje;
    }
    public String mensajeResultadoAtaqueJugador(String coordenadaDeAtaque){
        String mensaje = null;
        int x= Integer.parseInt(coordenadaDeAtaque.substring(0, 1));
        int y= Integer.parseInt(coordenadaDeAtaque.substring(1));
        if (!Objects.equals(computadora.tableroComputadora.tablero[y][x], "  ")){
            String elemento = computadora.tableroComputadora.tablero[y][x];
            if (elemento.equals(" *") || elemento.equals(" X")){
                System.out.println("Esta coordenada ya fue atacada antes.");
                mensaje = "FRACASADO";
            }else{
                computadora.tableroComputadora.tablero[y][x]= " *";
                int contador=0;
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (computadora.tableroComputadora.tablero[i][j].equals(elemento)){
                            contador+=1;
                        }
                    }
                }
                if (contador==0){
                    mensaje = "HUNDIDO";
                    computadora.setNumeroBarcos(1);
                }else{
                    mensaje = "IMPACTADO";
                }
            }
        } else if (computadora.tableroComputadora.tablero[y][x].equals("  ")) {
            mensaje = "AL AGUA";
        }
        return mensaje;
    }
    public void ReporteCompetencia(){
        if(!enCurso){
            ArrayList<Usuario> listaResultados = listaJugadores;
            listaResultados.add(computadora);
            listaResultados.sort(Comparator.comparingInt(Usuario::getNumeroIntentos).reversed());
            System.out.println("-*RESULTADOS FINALES*-");
            int i=1;
            for (Usuario usuario: listaResultados){
                System.out.println("Puesto-> "+i+", Alias-> "+usuario.getAlias()+", Intentos-> "+usuario.getNumeroIntentos()+".");
                i++;
            }
        }
    }
}
