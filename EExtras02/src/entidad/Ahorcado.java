/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

import java.util.Arrays;
import java.util.Scanner;

public class Ahorcado {

    private char[] palabra;
    private boolean[] acertadas;

    private int letrasEncontradas;
    private int intentosMaximos;
    private int intentosRestantes;

    public Ahorcado() {
        // constructor vacío
    }

    public Ahorcado(char[] palabra, int intentosMaximos) {
        this.palabra = palabra;
        this.letrasEncontradas = 0;
        this.intentosMaximos = intentosMaximos;
        this.intentosRestantes = intentosMaximos;
    }

    public void crearJuego() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la palabra a adivinar:");
        String palabraStr = scanner.nextLine().toUpperCase();
        this.palabra = palabraStr.toCharArray();
        this.acertadas = new boolean[palabra.length];
        Arrays.fill(acertadas, false);
        this.letrasEncontradas = 0;
        System.out.println("Ingrese la cantidad de intentos máximos (Sugeridos " + palabra.length + "): ");
        this.intentosMaximos = scanner.nextInt();
        this.intentosRestantes = this.intentosMaximos;
        for (int i = 0; i < 75; i++) {
            System.out.println("");
        }
    }

    public void longitud() {
        System.out.println("Longitud de la palabra: " + this.palabra.length);
    }

    public boolean buscar(char letra) {
        boolean encontrada = false;
        for (int i = 0; i < this.palabra.length; i++) {
            if (this.palabra[i] == letra) {
                encontrada = true;
                acertadas[i] = true;
                if (!acertadas[i]) this.letrasEncontradas++; // Para no repetir la suma innecesariamente
            }
        }
        if (!encontrada) {
            this.intentosRestantes--;
            System.out.println("La letra no está en la palabra");
        } else {
            System.out.println("La letra está en la palabra");
        }
        return encontrada;
    }

    public void encontradas() {
        int faltantes = this.palabra.length - this.letrasEncontradas;
        char[] palabraEncontrada = new char[this.palabra.length];
        Arrays.fill(palabraEncontrada, '_');
        for (int i = 0; i < this.palabra.length; i++) {
            if (acertadas[i]) {
                palabraEncontrada[i] = this.palabra[i];
            }
        }
        System.out.println("\nHasta Ahora: " + new String(palabraEncontrada));
        System.out.println("Número de letras (encontradas, faltantes): (" + this.letrasEncontradas + "," + faltantes + ")\n");
    }

    public void intentos() {
        System.out.println("Número de oportunidades restantes: " + this.intentosRestantes);
    }

    public void juego() {
        Scanner scanner = new Scanner(System.in);
        boolean completado = false;
        while (!completado && this.intentosRestantes > 0) {
            System.out.println("Ingrese una letra:");
            char letra = scanner.next().toUpperCase().charAt(0);
            if (this.buscar(letra)) {
                boolean todasAcertadas=true;
                this.encontradas();
                for (boolean acertada : acertadas) {
                    if (!acertada) {
                       todasAcertadas = false;
                    }
                }
               
                if ( todasAcertadas ) {
                    completado = true;
                    System.out.println("¡Felicidades, has ganado!");
                }
            } else {
                this.intentos();
            }
        }
        if (!completado) {
            System.out.println("¡Lo siento, has perdido! La palabra era: " + new String(this.palabra));
        }
    }
}
