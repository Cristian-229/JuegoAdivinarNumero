package juego;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase que contiene la lógica del juego
 */
public class Logica {
    private int numeroSecreto;
    private int intentosMaximos;
    private int rangoMin;
    private int rangoMax;

    public Logica(int intentosMaximos, int rangoMin, int rangoMax) {
        this.intentosMaximos = intentosMaximos;
        this.rangoMin = rangoMin;
        this.rangoMax = rangoMax;
        generarNumeroSecreto();
    }

    /**
     * Genera un número secreto aleatorio dentro del rango definido en main
     */
    public void generarNumeroSecreto() {
        Random rand = new Random();
        numeroSecreto = rand.nextInt(rangoMax - rangoMin + 1) + rangoMin;
    }

    /**
     * Lógica principal del juego.
     */
    public void jugar(Scanner sc) {
        System.out.println("¡Adivina el número entre " + rangoMin + " y " + rangoMax + "!");
        boolean adivinado = false;

        for (int intento = 1; intento <= intentosMaximos; intento++) {
            System.out.print("Intento " + intento + "/" + intentosMaximos + ". Ingresa tu número: ");
            int numeroUsuario;

            // Validación
            try {
                numeroUsuario = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor ingresa un número válido.");
                sc.nextLine(); // Limpia
                intento--; // No contar este intento
                continue;
            }

            if (numeroUsuario == numeroSecreto) {
                System.out.println("¡Felicidades! Adivinaste el número en " + intento + " intento(s).");
                adivinado = true;
                break;
            } else if (numeroUsuario < numeroSecreto) {
                System.out.println("El número es mayor.");
            } else {
                System.out.println("El número es menor.");
            }
        }

        if (!adivinado) {
            System.out.println("¡Te quedaste sin intentos! El número era: " + numeroSecreto);
        }
    }
}
