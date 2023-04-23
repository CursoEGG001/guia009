/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase09;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Crea una clase en Java donde declares una variable de tipo array de Strings que contenga los doce meses del año, en
 * minúsculas. A continuación, declara una variable mesSecreto de tipo String, y hazla igual a un elemento del array (por
 * ejemplo, mesSecreto = mes[9]. El programa debe pedir al usuario que adivine el mes secreto. Si el usuario acierta mostrar
 * un mensaje, y si no lo hace, pedir que vuelva a intentar adivinar el mes secreto. Un ejemplo de ejecución del programa
 * podría ser este: Adivine el mes secreto. Introduzca el nombre del mes en minúsculas: febrero No ha acertado. Intente
 * adivinarlo introduciendo otro mes: agosto ¡Ha acertado!
 *
 * @author pc
 */
public class EExtras01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
        String mesSecreto = meses[(int)(Math.random() * 11 )]; // alguno será
        Scanner scanner = new Scanner(System.in);
        String mesIntento;

        do {
            System.out.print("Adivina el mes secreto. Introduce el nombre del mes en minúsculas: ");
            mesIntento = scanner.nextLine();
        } while (!Arrays.asList(meses).contains(mesIntento));

        if (mesIntento.equals(mesSecreto)) {
            System.out.println("¡Has acertado!");
        } else {
            System.out.println("No has acertado. Inténtalo de nuevo.");
        }
    }
}

        