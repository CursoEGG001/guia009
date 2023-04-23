/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase09;

import java.util.Date;
import java.util.Scanner;
import servicios.FechaService;

/**
 * Vamos a usar la clase Date que ya existe en Java. Crearemos la clase FechaService, en paquete Servicios, que tenga los
 * siguientes métodos: a) Método fechaNacimiento que pregunte al usuario día, mes y año de su nacimiento. Luego los pase por
 * parámetro a un nuevo objeto Date. El método debe retornar el objeto Date. Ejemplo fecha: Date fecha = new Date(anio, mes,
 * dia); b) Método fechaActual que cree un objeto fecha con el día actual. Para esto usaremos el constructor vacío de la
 * clase Date. Ejemplo: Date fechaActual = new Date(); El método debe retornar el objeto Date. c) Método diferencia que
 * reciba las dos fechas por parámetro y retorna la diferencia de años entre una y otra (edad del usuario).
 *
 * @author pc
 */
public class Ejercicio04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Date fechaNacimiento = FechaService.fechaNacimiento(sc);
        System.out.println("Fecha de nacimiento: " + fechaNacimiento);

        Date fechaActual = FechaService.fechaActual();
        System.out.println("Fecha actual: " + fechaActual);

        int diferencia = FechaService.diferencia(fechaActual, fechaNacimiento);
        System.out.println("Edad: " + diferencia + " años");

        sc.close();
    }
}
