/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Entidad.ParDeNumeros;

/**
 * Realizar una clase llamada ParDeNumeros que tenga como atributos dos números reales con los cuales se realizarán
 * diferentes operaciones matemáticas. La clase debe tener un constructor vacío, getters y setters. En el constructor vacío
 * se usará el Math.random para generar los dos números. Crear una clase ParDeNumerosService, en el paquete Servicios, que
 * deberá además implementar los siguientes métodos: 
 * a) Método mostrarValores que muestra cuáles son los dos números guardados. 
 * b) Método devolverMayor para retornar cuál de los dos atributos tiene el mayor valor 
 * c) Método calcularPotencia para calcular la potencia del mayor valor de la clase elevado al menor número.
 * Previamente se deben redondear ambos valores. 
 * d) Método calculaRaiz, para calcular la raíz cuadrada del menor de los dos valores. Antes de calcular la raíz
 * cuadrada se debe obtener el valor absoluto del número.
 *
 * @author pc
 */
 
public class ParDeNumerosServicio {
    private ParDeNumeros parDeNumeros;
    
    public ParDeNumerosServicio(ParDeNumeros parDeNumeros) {
        this.parDeNumeros = parDeNumeros;
    }
    
    public void mostrarValores() {
        System.out.println("Número 1: " + parDeNumeros.getNumero1());
        System.out.println("Número 2: " + parDeNumeros.getNumero2());
    }
    
    public double devolverMayor() {
        double ponNumero = 0;
        if (parDeNumeros.getNumero2() < parDeNumeros.getNumero1()) {
            ponNumero = parDeNumeros.getNumero1();
        } else {
            ponNumero = parDeNumeros.getNumero2();
        }
        return ponNumero;
    }
    
    public double calcularPotencia() {
        double mayor = devolverMayor();
        double menor = (mayor == parDeNumeros.getNumero1()) ? parDeNumeros.getNumero2() : parDeNumeros.getNumero1();
        mayor = Math.round(mayor);
        menor = Math.round(menor);
        return Math.pow(mayor, menor);
    }
    
    public double calcularRaiz() {
        double mayor = devolverMayor();
        double menor = (mayor == parDeNumeros.getNumero1()) ? parDeNumeros.getNumero2() : parDeNumeros.getNumero1();
        menor = Math.abs(menor);
        return Math.sqrt(menor);
    }
}
