package model;

import java.util.ArrayList;
import java.util.Scanner;
/*Clase ADMINISTRADOR: Clase que se encarga de inicializar y crear Jugadores y una competencia, respectivamente.*/
public class Administrador {
    /*Atributos de la clase Administrador.*/
    private String alias;
    private String contrasena;
    private Boolean inicioCorrecto;
    private Competencia competencia;
    /*Método constructor de la clase Administrador.*/
    public Administrador(String alias, String contrasena) {
        /*Excepción para manejar la correcta creación de un objeto de tipo administrador.*/
        try{
            if(alias.equals("admin") && contrasena.equals("pass")){
                this.alias = alias;
                this.contrasena = contrasena;
                this.inicioCorrecto = true;
            }else {
                throw new RuntimeException("El nombre y la contrasena son incorrectos");
            }
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }
    /*Métodos Get y Set*/
    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    public Boolean getInicioCorrecto() {
        return inicioCorrecto;
    }

    public void setInicioCorrecto(Boolean inicioCorrecto) {
        this.inicioCorrecto = inicioCorrecto;
    }

    /*Métodos de la Clase.*/
    public void iniciarComptencia(){
        /*Método iniciarCompetencia: Método que se encarga de la creación de los jugadores, ubicación de los barcos de
         los mismos, creación de un Computador e inicializar una partida del juego.*/
        ArrayList<Usuario> listaJugadores = new ArrayList<>();
        Computadora computadora = new Computadora("Computadora", "0",
                "COMPUTADORA", new Tablero(), 0, 10);

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el numero de jugadores para la partida -> ");
        int numeroJugadores = sc.nextInt();
        sc.nextLine();
        String nombre;
        String documentoIdentidad;
        String alias;
        int numeroIntentos = 0;
        for (int i = 0; i < numeroJugadores; i++) {
            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
            System.out.println("Jugador "+ (i+1));
            System.out.print("Ingrese el nombre del jugador -> ");
            nombre = sc.nextLine();
            System.out.print("Ingrese el documento del jugador -> ");
            documentoIdentidad = sc.nextLine();
            System.out.print("Ingrese el alias del jugador -> ");
            alias = sc.nextLine();
            Jugador j = new Jugador(nombre, documentoIdentidad, alias, 0, new Tablero(), new Tablero());
            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
            j.ubicarBarcosJugador();
            listaJugadores.add(j);
        }
        competencia = new Competencia(computadora, listaJugadores);
    }


}
