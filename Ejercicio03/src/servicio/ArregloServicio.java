/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;
import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author pc
 */


public class ArregloServicio {

    public static void inicializarA(double[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = Math.floor(Math.random() * 100);
        }
    }

    public static void mostrar(double[] arreglo) {
        System.out.println(Arrays.toString(arreglo));
    }

    public static void ordenar(double[] arreglo) {
        Arrays.sort(arreglo);
        for (int i = 0; i < arreglo.length / 2; i++) {
            double temp = arreglo[i];
            arreglo[i] = arreglo[arreglo.length - i - 1];
            arreglo[arreglo.length - i - 1] = temp;
        }
    }

    public static void inicializarB(double[] arregloA, double[] arregloB) {
        for (int i = 0; i < 10; i++) {
            arregloB[i] = arregloA[i];
        }
        Arrays.fill(arregloB, 10, arregloB.length, 0.5);
       
    }
}
