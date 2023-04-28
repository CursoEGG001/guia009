/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

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


import Establecimiento.Alumno;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AlumnoServicio {
    private List<Alumno> listaAlumnos;

    public AlumnoServicio() {
        this.listaAlumnos = new ArrayList<>();
    }

    public void altaAlumno(String nombre, String apellido, String nacionalidad, Calendar fechaNacimiento) {
        Alumno nuevoAlumno = new Alumno(nombre, apellido, nacionalidad, fechaNacimiento);
        listaAlumnos.add(nuevoAlumno);
    }

    public void bajaAlumno(Alumno alumno) {
        listaAlumnos.remove(alumno);
    }

    public void modificarAlumno(Alumno alumno, String nombre, String apellido, String nacionalidad, Calendar fechaNacimiento) {
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setNacionalidad(nacionalidad);
        alumno.setFechaNacimiento(fechaNacimiento);
    }

    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void ordenarPorApellidoAscendente() {
        Collections.sort(listaAlumnos, Comparator.comparing(Alumno::getApellido));
    }

    public void ordenarPorNombreDescendente() {
        Collections.sort(listaAlumnos, Comparator.comparing(Alumno::getNombre).reversed());
    }

    public int calcularEdad(String nombre, String apellido) {
        Alumno alumno = buscarAlumno(nombre, apellido);
        if (alumno != null) {
            return alumno.getEdad();
        }
        return -1;
    }

    public List<Alumno> getListaAlumnosPorNacionalidad(String nacionalidad) {
        List<Alumno> listaAlumnosNacionalidad = new ArrayList<>();
        for (Alumno alumno : listaAlumnos) {
            if (alumno.getNacionalidad().equals(nacionalidad)) {
                listaAlumnosNacionalidad.add(alumno);
            }
        }
        return listaAlumnosNacionalidad;
    }

    public int contarMayoresDe25() {
        int contador = 0;
        for (Alumno alumno : listaAlumnos) {
            if (alumno.getEdad() > 25) {
                contador++;
            }
        }
        return contador;
    }

    public int contarApellidosConLyoP() {
        int contador = 0;
        for (Alumno alumno : listaAlumnos) {
            String primerLetra = String.valueOf(alumno.getApellido().charAt(0));
            if (primerLetra.equalsIgnoreCase("l") || primerLetra.equalsIgnoreCase("p")) {
                contador++;
            }
        }
        return contador;
    }

    public int contarAlumnosPorNacionalidad(String nacionalidad) {
        int contador = 0;
        for (Alumno alumno : listaAlumnos) {
            if (alumno.getNacionalidad().equals(nacionalidad)) {
                contador++;
            }
        }
        return contador;
    }

    public Alumno buscarAlumno(String nombre, String apellido) {
        for (Alumno alumno : listaAlumnos) {
            if (alumno.getNombre().equals(nombre) && alumno.getApellido().equals(apellido)) {
                return alumno;
            }
        }
        return null;
    }
}
