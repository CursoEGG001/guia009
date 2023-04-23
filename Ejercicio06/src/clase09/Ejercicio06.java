/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase09;

import entidad.Curso;
import java.util.Scanner;

/**
 * Un profesor particular está dando cursos para grupos de cinco alumnos y necesita un programa para organizar la información
 * de cada curso. Para ello, crearemos una clase entidad llamada Curso, cuyos atributos serán: nombreCurso,
 * cantidadHorasPorDia, cantidadDiasPorSemana, turno (mañana o tarde), precioPorHora y alumnos. Donde alumnos es un arreglo
 * de tipo String de dimensión 5 (cinco), donde se alojarán los nombres de cada alumno. A continuación, se implementarán los
 * siguientes métodos: a) Un constructor por defecto. b) Un constructor con todos los atributos como parámetro. c) Métodos
 * getters y setters de cada atributo. d) Método cargarAlumnos(): este método le permitirá al usuario ingresar los alumnos
 * que asisten a las clases. Nosotros nos encargaremos de almacenar esta información en un arreglo e iterar con un bucle,
 * solicitando en cada repetición que se ingrese el nombre de cada alumno. e) Método crearCurso(): el método crear curso, le
 * pide los valores de los atributos al usuario y después se le asignan a sus respectivos atributos para llenar el objeto
 * Curso. En este método invocamos al método cargarAlumnos() para asignarle valor al atributo alumnos f) Método
 * calcularGananciaSemanal(): este método se encarga de calcular la ganancia en una semana por curso. Para ello, se deben
 * multiplicar la cantidad de horas por día, el precio por hora, la cantidad de alumnos y la cantidad de días a la semana que
 * se repite el encuentro.
 *
 * @author pc
 */
public class Ejercicio06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Curso curso = new Curso();

        System.out.print("Ingrese el nombre del curso: ");
        curso.setNombreCurso(scanner.nextLine());

        System.out.print("Ingrese la cantidad de horas por día: ");
        curso.setCantidadHorasPorDia(scanner.nextInt());
        scanner.nextLine(); // Consumir el salto de línea después de ingresar un número

        System.out.print("Ingrese la cantidad de días por semana: ");
        curso.setCantidadDiasPorSemana(scanner.nextInt());
        scanner.nextLine(); // Consumir el salto de línea después de ingresar un número

        System.out.print("Ingrese el turno (mañana o tarde): ");
        curso.setTurno(scanner.nextLine());

        System.out.print("Ingrese el precio por hora: ");
        curso.setPrecioPorHora(scanner.nextDouble());
        scanner.nextLine(); // Consumir el salto de línea después de ingresar un número

        curso.cargarAlumnos();
        System.out.println("\nInformación del curso:");
        System.out.println(curso.toString());

        double gananciaSemanal = curso.calcularGananciaSemanal();
        System.out.println("La ganancia semanal del curso es: $" + gananciaSemanal);

        scanner.close();
    }
}
