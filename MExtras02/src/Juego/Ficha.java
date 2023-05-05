/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juego;

/**
 * Implementa un clase Ficha (de dominó) con su constructor y sus getters, con un toString() (que imprima el “seis-zero” como
 * “6:0|” y con un método llamado “Ficha girarFicha()” que gire la ficha (el “6:0|” pasaría a ser “0:6|”). Implementa también
 * el método “boolean esUnDoble()”. A) Ahora implementa con ArrayLists una clase que genere todas las fichas desde el doble 0
 * al doble MAX_NUM. Después, el programa, actuando como si fuera un robot jugando al solitario, empezará por tirar el doble
 * más grande e irá tirando fichas (las jugadas tienen que ser legales) hasta que haya tirado todas sus fichas (de su “mano”
 * a la “mesa) o ya no pueda tirar ninguna ficha más. Tu ejecución puede ser diferente de las de los ejemplos dependiendo de
 * cómo lo implementes.
 *
 * @author pc
 */
public class Ficha {

    private int ladoIzquierdo;
    private int ladoDerecho;

    public Ficha() {
    }
        
    public Ficha(int ladoIzquierdo, int ladoDerecho) {
        this.ladoIzquierdo = ladoIzquierdo;
        this.ladoDerecho = ladoDerecho;
    }

    public int getLadoIzquierdo() {
        return ladoIzquierdo;
    }

    public int getLadoDerecho() {
        return ladoDerecho;
    }

    public Ficha girarFicha() {
        return new Ficha(ladoDerecho, ladoIzquierdo);
    }

    public boolean esUnDoble() {
        return ladoIzquierdo == ladoDerecho;
    }

    /**
     * Es el Contenido de las Fichas Creadas. Las de Lado Izquierdo y Lado Derecho son variables con los números de la ficha
     * de dominó.
     *
     * @return
     */
    @Override
    public String toString() {
        return ladoIzquierdo + ":" + ladoDerecho + "|";
    }
}
