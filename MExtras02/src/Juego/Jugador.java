/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juego;

import Servicio.FichaServicio;
import java.util.List;

/**
 *
 * @author pc
 */
public class Jugador {

    public static boolean Juega(String nombre, List<Ficha> manoJuego, List<Ficha> pilaDescarte, boolean noJuega) {
        List<Ficha> usables = FichaServicio.getCombinables(pilaDescarte, manoJuego);
        Ficha laFicha = new Ficha();
        if (!noJuega) {

            int cntMAX = -1;
            for (Ficha usable : usables) {
                if (cntMAX < usable.getLadoDerecho() + usable.getLadoIzquierdo()) {
                    cntMAX = usable.getLadoDerecho() + usable.getLadoIzquierdo();
                    laFicha = usable;
                }

            }
            if (!usables.isEmpty()) {
                System.out.println(nombre + " usó una Ficha");
                return (FichaServicio.poneFicha(pilaDescarte, manoJuego, laFicha));
            } else {
                System.out.println("Pasa la mano " + nombre);
                return false;
            }
            //return true; Solo cuando puede jugar.
        } else {
            System.out.println(nombre + " no juega ahora.");
            return false;
        }
    }

//    public static int Pasa(boolean[] pasa, List<Ficha>[] manos, List<Ficha> pila, int contador) {
//        int numJugadores = pasa.length;
//        int jugadorActual = (contador % numJugadores);
//
//        if (pasa[(jugadorActual)]) {
//            manos[(jugadorActual)].add(pila.remove(0));
//            pasa[(jugadorActual)] = false;
//        }
//
//        return (jugadorActual);
//    }

}
