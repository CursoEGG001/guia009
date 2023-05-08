/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Juego.Ficha;
import java.util.ArrayList;
import java.util.List;

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
public class FichaServicio {

    private static final int MAX_NUM = 6;

    public static List<Ficha> generarFichas() {
        List<Ficha> fichas = new ArrayList<>();
        for (int i = 0; i <= MAX_NUM; i++) {
            for (int j = i; j <= MAX_NUM; j++) {
                fichas.add(new Ficha(i, j));
            }
        }
        return fichas;
    }

    /**
     * Devuelve una lista de Fichas que pueden jugarse en la otra pila
     *
     * @param pil1 Se comparan solo los extremos de esta lista.
     * @param pil2 Se comparan todos los valores de la lista contra los extremos de la otra lista de fichas.
     * @return Es la lista de las fichas que se pueden jugar en pila 1.
     */
    public static List<Ficha> getCombinables(List<Ficha> pil1, List<Ficha> pil2) {
        List<Ficha> elementos = new ArrayList<>();
        Ficha aComparar = pil1.get(0);
        for (int p1 = 0; p1 < pil2.size(); p1++) {
            if (aComparar.getLadoIzquierdo() == pil2.get(p1).getLadoIzquierdo()
                    || aComparar.getLadoIzquierdo() == pil2.get(p1).getLadoDerecho()) {
                elementos.add(pil2.get(p1));
            }
        }
        aComparar = pil1.get(pil1.size() - 1);
        for (int p2 = 0; p2 < pil2.size(); p2++) {
            if (aComparar.getLadoIzquierdo() == pil2.get(p2).getLadoIzquierdo()
                    || aComparar.getLadoIzquierdo() == pil2.get(p2).getLadoDerecho()) {
                elementos.add(pil2.get(p2));
            }
        }
        return elementos;
    }

    /**
     * La Ficha se pasa de la pila 2 a la pila 1. Devuelve verdadero si funcionó la operación
     *
     * @param pila1 La pila que recibe la ficha
     * @param pila2 La pila que aporta la ficha
     * @param ficha La ficha conocida
     * @return si puede realizar la operación da verdadero
     */
    public static boolean poneFicha(List<Ficha> pila1, List<Ficha> pila2, Ficha ficha) {
        boolean bandera=false;
        if (!pila2.isEmpty()) {

            if (ficha.getLadoDerecho() == pila1.get(0).getLadoIzquierdo()) {
                pila1.add(0, ficha);
                pila2.remove(ficha);
                System.out.println("Ficha Elegida en la izquierda");
                bandera = true;
            } else if (ficha.getLadoIzquierdo() == pila1.get((pila1.size() - 1)).getLadoDerecho()) {
                pila1.add(pila1.size() - 1, ficha);
                pila2.remove(ficha);
                System.out.println("Ficha Elegida en la derecha");
                bandera = true;
            } else if (ficha.girarFicha().getLadoDerecho() == pila1.get(0).getLadoIzquierdo()) {
                pila1.add(0, ficha.girarFicha());
                pila2.remove(ficha.girarFicha());
                System.out.println("Ficha Elegida girada puesta a la Izquierda");
                bandera = true;
            } else if (ficha.girarFicha().getLadoIzquierdo() == pila1.get((pila1.size() - 1)).getLadoDerecho()) {
                pila1.add((pila1.size() - 1), ficha.girarFicha());
                pila2.remove(ficha.girarFicha());
                System.out.println("Ficha Elegida girada puesta a la Derecha");
                bandera = true;

            } else {
                System.out.println("No hay Ficha para jugar");
                bandera = false;
            }

            return bandera;
        } else {
            System.out.println("No quedan Fichas ahí");
            return bandera;
        }
    }
}
