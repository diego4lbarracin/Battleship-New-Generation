package view;

import model.Administrador;

import java.util.Scanner;
/*Clase GUITexto: La clase contiene toda la lógica relacionada con una interfaz gráfica basada en
* texto para que el usuario interactúe con el juego.*/
public class GUITexto {
     public static String battleshipLogo =
            "  ____        _   _   _           _     _       \n" +
                    " |  _ \\      | | | | | |         | |   (_)      \n" +
                    " | |_) | __ _| |_| |_| | ___  ___| |__  _ _ __  \n" +
                    " |  _ < / _` | __| __| |/ _ \\/ __| '_ \\| | '_ \\ \n" +
                    " | |_) | (_| | |_| |_| |  __/\\__ \\ | | | | |_) |\n" +
                    " |____/ \\__,_|\\__|\\__|_|\\___||___/_| |_|_| .__/ \n" +
                    "                                         | |    \n" +
                    "                                         |_|    \n"+
             "                      New Generation                     ";

    public static void interfazDeJuego() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        String alias, contrasena;
        System.out.println("INICIO DE SESION");
        System.out.print("Usuario -> ");
        alias = sc.nextLine();
        System.out.print("Contrasena -> ");
        contrasena = sc.nextLine();
        Administrador administradorPartida = new Administrador(alias, contrasena);
        if (administradorPartida.getInicioCorrecto()) {
            /*Si el administrador se registró correctamente, entonces inicia el juego.*/
            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
            System.out.println("El administrador ha iniciado sesion correctamente.");
            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
            int opcion = 0;

            System.out.println(battleshipLogo);
            System.out.println("-----------------------------------------------------");
            do {
                System.out.println("Menu Principal.");
                System.out.println("(1) Iniciar Partida.");
                System.out.println("(2) Salir.");
                System.out.print("Seleccione una opcion -> ");
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1 -> {
                        administradorPartida.iniciarComptencia();
                        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                        administradorPartida.getCompetencia().secuenciaDeTurnosDeJuego();
                        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                        administradorPartida.getCompetencia().generarReporteCompetencia();
                        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                    }
                    case 2 -> {
                        System.out.println("Ha salido del juego.");
                    }
                    default -> {
                        System.out.println("Seleccione una opcion correcta.");
                    }
                }
            } while (opcion != 2);
        }
    }
}
