package juego;

import java.util.Scanner;

/**
 * Clase principal que muestra el menú e inicia el juego.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Jugar");
            System.out.println("2. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion;
            try {
                opcion = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Opción inválida.");
                sc.nextLine(); // Limpia
                continue;
            }

            switch (opcion) {
                case 1:
                    // Valores que podemos cambiar
                    int intentosMaximos = 5;
                    int rangoMin = 1;
                    int rangoMax = 50;

                    Logica juego = new Logica(intentosMaximos, rangoMin, rangoMax);
                    juego.jugar(sc);
                    break;
                case 2:
                    System.out.println("¡Hasta luego!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
        sc.close();
    }
}
