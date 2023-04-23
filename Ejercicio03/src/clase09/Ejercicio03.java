/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase09;

import servicio.ArregloServicio;

/**
 * Crear en el Main dos arreglos. El arreglo A de 50 números reales y el arreglo B de 20 números reales. Crear la clase
 * ArregloService, en el paquete servicio, con los siguientes métodos: 1) Método inicializarA recibe un arreglo por parámetro
 * y lo inicializa con números aleatorios. 2) Método mostrar recibe un arreglo por parámetro y lo muestra por pantalla. 3)
 * Método ordenar recibe un arreglo por parámetro y lo ordena de mayor a menor. 4) Método inicializarB copia los primeros 10
 * números del arreglo A en el arreglo B. Luego llenar las últimas 10 posiciones del arreglo B con 0.5. En el Main
 * nuevamente: inicializar A, mostrar A, ordenar A, inicializar B, mostrar A y B.
 */
public class Ejercicio03 {

    public static void main(String[] args) {
        double[] arregloA = new double[50];
        double[] arregloB = new double[20];

        ArregloServicio.inicializarA(arregloA);
        System.out.println("Arreglo A:");
        ArregloServicio.mostrar(arregloA);

        ArregloServicio.ordenar(arregloA);
        System.out.println("Arreglo A ordenado de mayor a menor:");
        ArregloServicio.mostrar(arregloA);

        ArregloServicio.inicializarB(arregloA, arregloB);
        System.out.println("De nuevo, Arreglo A:");
        ArregloServicio.mostrar(arregloA);
        System.out.println("Arreglo B:");
        ArregloServicio.mostrar(arregloB);
    }

}
