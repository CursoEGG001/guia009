/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;


import entidades.Persona;
import java.util.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class PersonaService {
    
    public Persona crearPersona() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la persona:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese la fecha de nacimiento de la persona (formato dd/mm/yyyy):");
        String fechaNacimientoString = sc.nextLine();
        Date fechaNacimiento = parseFecha(fechaNacimientoString);
        Persona persona = new Persona(nombre, fechaNacimiento);
        return persona;
    }
    
    public int calcularEdad(Persona persona) {
        LocalDate fechaNacimiento = persona.getFechaNacimiento().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return (periodo.getYears()+1900);
    }
    
    public boolean menorQue(Persona persona, int edad) {
        int edadActual = calcularEdad(persona);
        return edadActual < edad;
    }
    
    public void mostrarPersona(Persona persona) {
        int edad = calcularEdad(persona);
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Fecha de nacimiento: " + persona.getFechaNacimiento());
        System.out.println("Edad: " + edad);
    }
    
    private Date parseFecha(String fecha) {
        String[] fechaSplit = fecha.split("/");
        int dia = Integer.parseInt(fechaSplit[0]);
        int mes = Integer.parseInt(fechaSplit[1]) - 1;
        int anio = Integer.parseInt(fechaSplit[2]);
        return new Date(anio, mes, dia);
    }
}
