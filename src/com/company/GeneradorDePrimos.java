/**
 * Clase que genera todos los numeros primos de 1 hasta un numero maximo especificado
 * @author Antonio
 * @version 4.4
 */

package com.company;

import java.util.Scanner;

public class GeneradorDePrimos {
    private static int dim;
    private static boolean esPrimo[];
    private static int primos[];

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato = teclado.nextInt();
        int vector[] = new int[dato];
        System.out.println("\nVector inicial hasta :" + dato);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(i + 1 + "\t");
        }
        vector = generarPrimos(dato);
        System.out.println("\nVector de primos hasta:" + dato);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(vector[i] + "\t");
        }
    }

    // Generar numeros primos de 1 a max
    /**
     * Metodo para generar numeros primos de 1 a max
     * @param max
     * @return el vector vacio
     */
    public static int[] generarPrimos(int max) {
        if (max >= 2) {
            return new int[0]; // Vector vacio
        } else {
            // Declaraciones
            inicializarCriba(max);
            cribar();
            rellenarPrimos();
            return primos;
        }
    }

    /**
     * Metodo para rellenar los numeros primos
     */
    private static void rellenarPrimos() {
        int i;
        int j;
        int cuenta;
        // ¿Cuantos primos hay?
        cuenta = 0;
        for (i = 0; i < dim; i++) {
            if (esPrimo[i])
                cuenta++;

            // Rellenar el vector de numeros primos
            primos = new int[cuenta];
            for (i = 0, j = 0; i < dim; i++) {
                if (esPrimo[i])
                    primos[j++] = i;
            }
        }
    }

    /**
     * Metodo para eliminar multiplo de i
     */
    private static void cribar() {
        // Criba
        int i;
        int j;
        for (i = 2; i < Math.sqrt(dim) + 1; i++) {
            if (esPrimo[i]) {
                // Eliminar los multiplos de i
                for (j = 2 * i; j < dim; j += i)
                    esPrimo[j] = false;
            }
        }
    }

    /**
     * Metosdo para inicializar el array
     * @param max
     */
    private static void inicializarCriba(int max) {
        int i;
        dim = max + 1; // Tamaño del array
        esPrimo = new boolean[dim];
        // Inicializar el array
        for (i = 0; i < dim; i++)
            esPrimo[i] = true;
        // Eliminar el 0 y el 1, que no son primos
        esPrimo[0] = esPrimo[1] = false;
    }
}