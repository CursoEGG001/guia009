/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import entidad.Ahorcado;

public class AhorcadoService {

    public static void jugar() {
        Ahorcado ahorcado = new Ahorcado();
        ahorcado.crearJuego();
        ahorcado.juego();
    }
}
