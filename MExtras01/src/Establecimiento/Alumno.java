/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Establecimiento;

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

import java.util.Calendar;

public class Alumno {
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private Calendar fechaNacimiento;

    public Alumno(String nombre, String apellido, String nacionalidad, Calendar fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getEdad() {
        Calendar hoy = Calendar.getInstance();
        int edad = hoy.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
        if (hoy.get(Calendar.MONTH) < fechaNacimiento.get(Calendar.MONTH)
                || (hoy.get(Calendar.MONTH) == fechaNacimiento.get(Calendar.MONTH)
                && hoy.get(Calendar.DAY_OF_MONTH) < fechaNacimiento.get(Calendar.DAY_OF_MONTH))) {
            edad--;
        }
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Alumno{ " +
                "nombre:'" + nombre + '\'' +
                ", apellido:'" + apellido + '\'' +
                ", nacionalidad:'" + nacionalidad + '\'' +
                ", fechaNacimiento:\t" + fechaNacimiento.get(Calendar.DAY_OF_MONTH) + "/" +
                (fechaNacimiento.get(Calendar.MONTH) + 1) + "/" +
                fechaNacimiento.get(Calendar.YEAR) +
                " }";
    }
}
