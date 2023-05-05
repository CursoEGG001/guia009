/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase09;

import Juego.Ficha;
import Servicio.FichaServicio;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Implementa un clase Ficha (de dominó) con su constructor y sus getters, con un toString() (que imprima el “seis-zero” como
 * “6:0|” y con un método llamado “Ficha girarFicha()” que gire la ficha (el “6:0|” pasaría a ser “0:6|”). Implementa también
 * el método “boolean esUnDoble()”. A) Ahora implementa con ArrayLists una clase que genere todas las fichas desde el doble 0
 * al doble MAX_NUM. Después, el programa, actuando como si fuera un robot jugando al solitario, empezará por tirar el doble
 * más grande e irá tirando fichas (las jugadas tienen que ser legales) hasta que haya tirado todas sus fichas (de su “mano”
 * a la “mesa") o ya no pueda tirar ninguna ficha más. Tu ejecución puede ser diferente de las de los ejemplos dependiendo de
 * cómo lo implementes.
 *
 *
 * @author pc
 *
 */
public class MExtras02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Ficha> mano1 = new ArrayList<>();
        List<Ficha> mano2 = new ArrayList<>();
        List<Ficha> mesa = new ArrayList<>();
        List<Ficha> pila = new ArrayList<>();

        pila = FichaServicio.generarFichas();
        System.out.println("Estas son las fichas:" + pila);

        Collections.shuffle(pila);

        // Repartimos las Fichas
        for (int i = 0; i < 7; i++) {
            mano1.add(pila.remove(0));
            mano2.add(pila.remove(0));

        }

        System.out.println("Mano 1: " + mano1);
        for (int i = 0; i < mano1.size(); i++) {
            System.out.print("(" + mano1.get(i) + ") _[" + i + "]_,");
        }
        System.out.println("");
        System.out.println("Mano 2: " + mano2);
        for (int i = 0; i < mano2.size(); i++) {
            System.out.print("(" + mano2.get(i) + ") _[" + i + "]_,");
        }
        System.out.println("En la Pila: " + pila);
        System.out.println("En la Mesa: " + mesa);

        //Buscamos el doble mas alto en la mano de los jugadores
        int max1 = 0;
        int max2 = 0;
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < mano1.size(); i++) {

            if (mano1.get(i).esUnDoble()) {
                if (mano1.get(i).getLadoDerecho() > max1) {
                    max1 = mano1.get(i).getLadoDerecho();
                    c1 = i;
                }
            }

        }

        for (int i = 0; i < mano2.size(); i++) {

            if (mano2.get(i).esUnDoble()) {
                if (mano2.get(i).getLadoDerecho() > max2) {
                    max2 = mano2.get(i).getLadoDerecho();
                    c2 = i;
                }
            }

        }

        //Sacamos cual de los dos jugadores comienza
        String JugadorActual;
        if (max1 > max2) {
            JugadorActual = "Primer Jugador";
        } else {
            JugadorActual = "Segundo Jugador";
        }
        System.out.println(JugadorActual + " comienza a jugar.");

        //Pone en la mesa una ficha doble el que empieza
        if (max1 > max2) {
            mesa.add(mano1.remove(c1));
        } else {
            mesa.add(mano2.remove(c2));
        }
        System.out.println("En la Mesa: " + mesa);

        //Aquí comienza el juego
        boolean existeJugada = false;

        do {
            if (pila.isEmpty()) {
                break;
            }
            Ficha buscada = new Ficha(); //Solo la crea, no pertenece al juego y almacena lo buscado    
            // Turno de buscar una pieza en la otra mano
            if (max1 > max2) {
                if (!mano2.isEmpty()) {
                    // Fijarse en las fichas de los extremos en la mesa si encuentro conjunto
                    List<Ficha> usables = FichaServicio.getCombinables(mesa, mano2);
                    for (int i = 0; i < mano2.size(); i++) {

                        int CntMAX = 0;
                        for (Ficha usable : usables) {

                            if (!usables.isEmpty() && usable.getLadoDerecho() + usable.getLadoIzquierdo() > CntMAX) {
                                CntMAX = usable.getLadoDerecho() + usable.getLadoIzquierdo();
                                buscada = usable;

                            }
                        }
                    }

                    existeJugada = FichaServicio.poneFicha(mesa, mano2, buscada);

                } else {
                    if (!pila.isEmpty()) {
                        existeJugada = false;
                    }
                }
            } else {
                if (!mano1.isEmpty()) {
                    // Fijarse en las fichas de los extremos en la mesa si encuentro conjunto
                    List<Ficha> usables = FichaServicio.getCombinables(mesa, mano1);
                    for (int i = 0; i < mano1.size(); i++) {
                        buscada = new Ficha(); //Solo la crea, no pertenece al juego y almacena lo buscado

                        int CntMAX = 0;
                        for (Ficha usable : usables) {

                            if (!usables.isEmpty() && usable.getLadoDerecho() + usable.getLadoIzquierdo() > CntMAX) {
                                CntMAX = usable.getLadoDerecho() + usable.getLadoIzquierdo();
                                buscada = usable;
                            } else {
                                existeJugada=false;
                            }

                        }
                    }

                    existeJugada = FichaServicio.poneFicha(mesa, mano1, buscada);

                } else {
                    if (!pila.isEmpty()) {

                        existeJugada = false;
                    }

                }
            }

            if (!existeJugada) {
                System.out.println("No puede jugar su ficha");
                if (max1 > max2) {
                    if (mesa.size() % 2 != 0) {
                        mano2.add(pila.remove(0));
                        existeJugada = true;

                    } else {
                        mano1.add(pila.remove(0));
                        existeJugada = true;
                    }
                } else {
                    if (mesa.size() % 2 != 0) {
                        mano1.add(pila.remove(0));
                        existeJugada = true;

                    } else {
                        mano2.add(pila.remove(0));
                        existeJugada = true;

                    }
                }
            } else {
                System.out.println("Esto Sigue...");
                break;
            }
            System.out.println("Mesa: " + mesa);
        } while (!(pila.isEmpty()) && (!mano1.isEmpty() || !mano2.isEmpty()));

        System.out.println("Mano 1: " + mano1);
        for (int i = 0; i < mano1.size(); i++) {
            System.out.print("(" + mano1.get(i) + ") _[" + i + "]_,");
        }
        System.out.println("");
        System.out.println("Mano 2: " + mano2);
        for (int i = 0; i < mano2.size(); i++) {
            System.out.print("(" + mano2.get(i) + ") _[" + i + "]_,");
        }
        System.out.println("\nEn la Pila: " + pila);
        System.out.println("En la Mesa: " + mesa);
    }
}
