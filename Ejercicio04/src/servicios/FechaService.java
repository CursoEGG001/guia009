/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author pc
 */

public class FechaService {

    public static Date fechaNacimiento(Scanner sc) {
        System.out.print("Ingrese día de nacimiento: ");
        int dia = sc.nextInt();
        System.out.print("Ingrese mes de nacimiento: ");
        int mes = sc.nextInt() - 1; // Los meses en la clase Date van de 0 a 11
        System.out.print("Ingrese año de nacimiento: ");
        int anio = sc.nextInt() - 1900; // Los años en la clase Date se cuentan a partir de 1900
        return new Date(anio, mes, dia);
    }

    public static Date fechaActual() {
        return new Date();
    }

    public static int diferencia(Date fecha1, Date fecha2) {
        return (int) ((fecha1.getTime() - fecha2.getTime()) / (1000 * 60 * 60 * 24 * 365L));
    }
}
