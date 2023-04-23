/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase09;

import entidades.Persona;
import Servicio.PersonaService;

/**
 * Implemente la clase Persona en el paquete entidades. Una persona tiene un nombre y una fecha de nacimiento (Tipo Date),
 * constructor vacío, constructor parametrizado, get y set. Crear una clase PersonaService, en el paquete servicio, con los
 * siguientes métodos: a) Método crearPersona que pida al usuario Nombre y fecha de nacimiento de la persona a crear.
 * Retornar el objeto Persona creado. b) Método calcularEdad que calcule la edad del usuario utilizando el atributo de fecha
 * de nacimiento y la fecha actual. c) Método menorQue recibe como parámetro una Persona y una edad. Retorna true si la
 * persona es menor que la edad consultada o false en caso contrario. d) Método mostrarPersona que muestra la información de
 * la persona deseada.
 *
 * @author pc
 */
public class Ejercicio05 {

    public static void main(String[] args) {
        PersonaService personaService = new PersonaService();

        Persona persona = personaService.crearPersona();

        int edad = personaService.calcularEdad(persona);
        System.out.println("Edad de la persona: " + edad);

        boolean esMenorQue25 = personaService.menorQue(persona, 25);
        if (esMenorQue25) {
            System.out.println(persona.getNombre() + " es menor que 25 años.");
        } else {
            System.out.println(persona.getNombre() + " no es menor que 25 años.");
        }

        personaService.mostrarPersona(persona);
    }
}
