/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase09;

import Entidad.ParDeNumeros;
import Servicio.ParDeNumerosServicio;

/**
 * Realizar una clase llamada ParDeNumeros que tenga como atributos dos números reales con los cuales se realizarán
 * diferentes operaciones matemáticas. La clase debe tener un constructor vacío, getters y setters. En el constructor vacío
 * se usará el Math.random para generar los dos números. Crear una clase ParDeNumerosService, en el paquete Servicios, que
 * deberá además implementar los siguientes métodos: a) Método mostrarValores que muestra cuáles son los dos números
 * guardados. b) Método devolverMayor para retornar cuál de los dos atributos tiene el mayor valor c) Método calcularPotencia
 * para calcular la potencia del mayor valor de la clase elevado al menor número. Previamente se deben redondear ambos
 * valores. d) Método calculaRaiz, para calcular la raíz cuadrada del menor de los dos valores. Antes de calcular la raíz
 * cuadrada se debe obtener el valor absoluto del número.
 *
 * @author pc
 */
public class Ejercicio02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ParDeNumeros nums1 = new ParDeNumeros();
        ParDeNumerosServicio pdnS1 = new ParDeNumerosServicio(nums1);

        System.out.println("Estos serían los valores: " + pdnS1.devolverMayor() + " es el mayor de los dos numeros " + nums1.getNumero1() + " y " + nums1.getNumero2());
        System.out.println("Estos sería así : " + pdnS1.devolverMayor() + " es el mayor de los dos numeros " + nums1.getNumero1() + " y " + nums1.getNumero2());
        System.out.println("Según este programa la potencia sería : " + pdnS1.calcularPotencia());
    }

}
