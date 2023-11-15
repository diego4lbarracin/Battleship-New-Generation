package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Administrador {
    private String alias;
    private String contrasena;
    private Boolean inicioCorrecto;
    private Competencia competencia;
    public Administrador(String alias, String contrasena) {

        /*Exception to handel the creation of an administrador. If the password and the name are not equal
        * to the ones in the condition, the object "Administrador" won't be created.*/
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

    public void iniciarComptencia(){
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
