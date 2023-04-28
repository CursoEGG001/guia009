/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase09;

import Establecimiento.Alumno;
import Servicio.AlumnoServicio;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Ejercicio1 (utilizar ArrayList) Crea una clase Alumnos, donde tendrá como Atributos el nombre, apellido, la nacionalidad y
 * su fecha de nacimiento. La nacionalidad podrá ser ARGENTINA – CHILENA – VENEZOLANA solamente. Necesidades:  Crear los
 * métodos de A – B -M (Alta – Baja – modificación ) que manipulen los objetos de este tipo.  Crear una lista de 20 alumnos
 * (hacer uso del constructor que recibe parámetros , para no hacer carga manual de los datos)  Ordenar y mostrar la lista
 * de alumnos ordenados por orden alfabético según su apellido de forma ascendente.  Ordenar y mostrar la lista de alumnos
 * ordenados por orden alfabético según su nombre de forma descendente.  Con un alumno especifico (suponiendo que no existen
 * dos alumnos con el mismo nombre y apellido), mostrar por pantalla su edad. Considerar, el manejo de fechas, utilizando el
 * atributo fecha de nacimiento.  Crear listas paralelas de Alumnos, según la nacionalidad.  Realizar un reporte final de
 * datos que informe: o Cuantos alumnos son mayores de 25 años. o Cuantos alumnos tiene su apellido que comienzan con letra L
 * o P o Cuantos alumnos hay de nacionalidad ARGENTINA – CHILENA – VENEZOLANA. Recordar:  Hacer uso de paquetes y clases
 * correspondientes para buena estructura de nuestro proyecto.  Todos los métodos deben ser pensados para reutilizar y
 * adaptarse a futuros cambios (por ejemplo, mañana quiero carga de 30 alumnos, y las instrucciones deben prevenir esta
 * modificación)
 */
public class MExtras01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Arreglos de nombres y apellidos al azar
        String[] nombres = {"Juan", "Pedro", "Luis", "Ana", "María", "Laura", "Lucía", "Jorge", "Mariano", "Lucas",
            "Gabriela", "Florencia", "Martina", "Micaela", "Facundo", "Agustín", "Leandro", "Tomás", "Sofía",
            "Camila"};
        String[] apellidos = {"Gómez", "Fernández", "Pérez", "González", "Sánchez", "Martínez", "Rodríguez", "López",
            "Díaz", "Torres", "Alvarez", "Ruiz", "Jiménez", "García", "Romero", "Silva", "Moreno", "Cabrera",
            "Flores", "Ramírez"};
        String[] nacionalidades = {"ARGENTINA", "CHILENA", "VENEZOLANA"};

        // Creación del servicio y carga de 20 alumnos
        AlumnoServicio servicio = new AlumnoServicio();
        for (int i = 0; i < 20; i++) {
            String nombre = nombres[(int) (Math.random() * nombres.length)];
            String apellido = apellidos[(int) (Math.random() * apellidos.length)];
            String nacionalidad = nacionalidades[(int) (Math.random() * nacionalidades.length)];
            Calendar fechaNacimiento = Calendar.getInstance();
            fechaNacimiento.set((int) (Math.random() * 25 + 1980), (int) (Math.random() * 11), (int) (Math.random() * 31));
            servicio.altaAlumno(nombre, apellido, nacionalidad, fechaNacimiento);
        }

        // Ordenar y mostrar la lista de alumnos por apellido ascendente
        servicio.ordenarPorApellidoAscendente();
        System.out.println("Lista de alumnos ordenada por apellido ascendente:");
        List<Alumno> listaAlumnos = servicio.getListaAlumnos();
        for (Alumno alumno : listaAlumnos) {
            System.out.println(alumno);
        }

        // Ordenar por nombres Descendentes
        servicio.ordenarPorNombreDescendente();
        System.out.println("Lista de alumnos ordenada por Nombres descendentes");
        listaAlumnos = servicio.getListaAlumnos();
        for (Alumno alumno : listaAlumnos) {
            System.out.println(alumno);
        }

        // Contar por Apellidos con L o P
        System.out.println(servicio.contarApellidosConLyoP() + " tienen L o P en el apellido");

        // Buscar un Alumno y calcula la edad
        String nombre = nombres[(int) (Math.random() * nombres.length)];
        String apellido = apellidos[(int) (Math.random() * apellidos.length)];

        System.out.println(servicio.calcularEdad(nombre, apellido) + " es la edad de " + nombre + " " + apellido);

        // Cuenta Mayores de 25
        System.out.println("Hay " + servicio.contarMayoresDe25() + " que tienen más de 25 años");

        // Veamos como borrar un Alumno
        Scanner dato = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el nombre del alumno y su apellido luego:");
        Alumno alumno = servicio.buscarAlumno(dato.next(), dato.next());
        servicio.bajaAlumno(alumno);
        listaAlumnos = servicio.getListaAlumnos();
        System.out.println("Esta es la nueva lista:");
        for (Alumno alumnoB : listaAlumnos) {
            System.out.println(alumnoB);
        }

        // Para Modificar un alumno
        System.out.println("Ingrese los datos del alumno a modificar:");
        alumno = servicio.buscarAlumno(dato.next(), dato.next());
        System.out.println("Ingrese el Nuevo Nombre y luego el nuevo apellido:");
        String n1 = dato.next();
        String ap1 = dato.next();
        String nc1 = "ARGENTINA";
        Calendar fechaNacimiento = Calendar.getInstance();
        fechaNacimiento.set((int) (Math.random() * 25 + 1980), (int) (Math.random() * 11), (int) (Math.random() * 31));
        servicio.modificarAlumno(alumno, n1, ap1, nc1, fechaNacimiento);
        for (Alumno alumnoB : listaAlumnos) {
            System.out.println(alumnoB);
        }

        // Contar por Nacionalidad
        String Criterio = nacionalidades[(int) (Math.random() * nacionalidades.length)];
        System.out.println(servicio.contarAlumnosPorNacionalidad(Criterio) + " son de nacionalidad " + Criterio);

        //Cuenta Alumnos por Nacionalidad
        System.out.println("\nListado por nacionalidad:\n");
        List<Alumno> listaNac = servicio.getListaAlumnosPorNacionalidad(Criterio);
        for (Alumno alumno1 : listaNac) {
            System.out.println(alumno1);
        }

    }
}
