package view;

import model.Administrador;

import java.util.Scanner;

public class GUITexto {
     private String battleshipLogo =
            "  ____        _   _   _           _     _       \n" +
                    " |  _ \\      | | | | | |         | |   (_)      \n" +
                    " | |_) | __ _| |_| |_| | ___  ___| |__  _ _ __  \n" +
                    " |  _ < / _` | __| __| |/ _ \\/ __| '_ \\| | '_ \\ \n" +
                    " | |_) | (_| | |_| |_| |  __/\\__ \\ | | | | |_) |\n" +
                    " |____/ \\__,_|\\__|\\__|_|\\___||___/_| |_|_| .__/ \n" +
                    "                                         | |    \n" +
                    "                                         |_|    \n";

    public void interfazDeJuego(){
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println(battleshipLogo);
        do {
            System.out.println("Menu Principal.");
            System.out.println("(1) Iniciar Partida.");
            System.out.println("(2) Salir.");
            System.out.println("Seleccione una opcion -> ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 1 -> {
                    String alias, contrasena;
                    System.out.println("Ingrese el nombre de usuario -> ");
                    alias = sc.nextLine();
                    System.out.println("Ingrese la contrasena -> ");
                    contrasena = sc.nextLine();
                    Administrador administradorPartida = new Administrador(alias,contrasena);
                    System.out.println("El administrador ha iniciado sesion correctamente.");
                    administradorPartida.iniciarComptencia();
                    administradorPartida.getCompetencia().secuenciaDeTurnosDeJuego();
                    administradorPartida.getCompetencia().ReporteCompetencia();
                }
                case 2 -> {
                    System.out.println("Ha salido del juego.");
                }
                default -> {
                    System.out.println("Seleccione una opcion correcta.");
                }
            }
        }while (opcion!=2);
    }
}
