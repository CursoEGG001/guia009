/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Entidades.Cadena;

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
public class CadenaServicio {

    private Cadena cadena;

    public CadenaServicio(Cadena cadena) {
        this.cadena = cadena;
    }

    public void setFrase(String frase) {
        this.cadena.setFrase(frase);
    }

    public int mostrarVocales() {
        int count = 0;
        String vocales = "aeiouAEIOU";

        for (int i = 0; i < this.cadena.getLongitud(); i++) {
            if (vocales.indexOf(this.cadena.getFrase().charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    public String invertirFrase() {
        String invertida = "";
        char[] letra = this.cadena.getFrase().toCharArray();
        for (int i = letra.length - 1; i >= 0; i--) {
            invertida += (letra[i]);
        }

        return invertida;
    }

    public int vecesRepetido(String letra) {
        int count = 0;
        for (int i = 0; i < this.cadena.getLongitud(); i++) {
            if (this.cadena.getFrase().charAt(i) == letra.charAt(0)) {
                count++;
            }
        }
        return count;
    }

    public boolean contiene(String letra) {
        return this.cadena.getFrase().contains(letra);
    }

    public String reemplazar(String letra, String reemplazo) {
        this.cadena.setFrase(this.cadena.getFrase().replace(letra, reemplazo));
        return this.cadena.getFrase();
    }

    public void unirFrases(String frase) {
        this.cadena.setFrase(this.cadena.getFrase() + " " + frase);
    }

    public void compararLongitud(String frase) {
        int longitud2 = frase.length();
        if (this.cadena.getLongitud() > longitud2) {
            System.out.println("La frase de la clase es más larga que la frase ingresada");
        } else if (this.cadena.getLongitud() < longitud2) {
            System.out.println("La frase ingresada es más larga que la frase de la clase");
        } else {
            System.out.println("Las frases tienen la misma longitud");
        }
    }
}
