/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gen;

/**
 *
 * @author pc
 */
public class Patron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 80; j++) {
                if (Math.random() < 0.5) {
                    System.out.print("┼");
                    
                } else {
                    System.out.print("┤");
                }
                
            }
            System.out.println("");
        }
    }
    
}
