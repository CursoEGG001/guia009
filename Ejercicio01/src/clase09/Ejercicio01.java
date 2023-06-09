/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase09;

import Entidades.Cadena;
import Servicio.CadenaServicio;

/**
 * Realizar una clase llamada Cadena, en el paquete de entidades, que tenga como atributos una frase (String) y su longitud.
 * Agregar constructor vacío y con atributo frase solamente. Agregar getters y setters. El constructor con frase como
 * atributo debe setear la longitud de la frase de manera automática. Crear una clase CadenaServicio en el paquete servicios
 * que implemente los siguientes métodos: Método mostrarVocales(), deberá contabilizar la cantidad de vocales que tiene la
 * frase ingresada. Método invertirFrase(), deberá invertir la frase ingresada y mostrarla por pantalla. Por ejemplo:
 * Entrada: "casa blanca", Salida: "acnalb asac". Método vecesRepetido(String letra), recibirá un carácter ingresado por el
 * usuario y contabilizar cuántas veces se repite el carácter en la frase, por ejemplo: Entrada: frase = "casa blanca".
 * Salida: El carácter 'a' se repite 4 veces. Método compararLongitud(String frase), deberá comparar la longitud de la frase
 * que compone la clase con otra nueva frase ingresada por el usuario. Método unirFrases(String frase), deberá unir la frase
 * contenida en la clase Cadena con una nueva frase ingresada por el usuario y mostrar la frase resultante. Método
 * reemplazar(String letra), deberá reemplazar todas las letras “a” que se encuentren en la frase, por algún otro carácter
 * seleccionado por el usuario y mostrar la frase resultante. Método contiene(String letra), deberá comprobar si la frase
 * contiene una letra que ingresa el usuario y devuelve verdadero si la contiene y falso si no.
 *
 * @author pc
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cadena cadena = new Cadena("Casa Blanca colorada");
        CadenaServicio servicio = new CadenaServicio(cadena);
        System.out.println("La frase tiene " + servicio.mostrarVocales() + " vocales");
        System.out.println("Cuenta con c al menos " + servicio.vecesRepetido("c") + " veces");
        System.out.println("La frase invertida es: " + servicio.invertirFrase());
        System.out.println("Te cambia a por \"~\" : "
                + servicio.reemplazar("a", "~"));
        if (servicio.contiene("B")) {
            System.out.println("Esta tiene tambien la letra \"B\"");
        }
        servicio.compararLongitud("La casa blanca");
        servicio.unirFrases("gigante");
        System.out.println("Tenemos ahora: \n" + cadena.getFrase());
    }

}
