/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package utilidad;

import java.util.Calendar;

import java.util.Scanner;

/**
 *
 * @author pc
 */
public class Calendario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Conseguir primer fecha
        System.out.println("Entre fecha de Nacimiento (YYYY-MM-DD):");
        String date1String = scanner.nextLine();
        String[] date1Parts = date1String.split("-");
        int year1 = Integer.parseInt(date1Parts[0]);
        int month1 = Integer.parseInt(date1Parts[1]) - 1; // Los meses comienzan desde 0
        int day1 = Integer.parseInt(date1Parts[2]);

        // Conseguir segunda fecha (Con instancia Calendar)
        Calendar datenow = Calendar.getInstance();
        //Fechas pasadas a String
        String date2String = datenow.getTime().toString();
        System.out.println("Esto hay en date2String : " + date2String);
        // Repartija de Strings en Array
        String[] date2Parts = date2String.split(" ");
        // Obtengo Años desde String
        int year2 = Integer.parseInt(date2Parts[5]);
        // Muestras comparativas de Calendar y el String
        System.out.println("Añitos: " + year2 + "\n que es igual que " + datenow.get(Calendar.YEAR));
        // Es lo mismo puesto 2 veces
        int month2 = datenow.get(Calendar.MONTH)+1;
        System.out.println("Mesesitos: " + month2 + "\n podria ser así:" + (datenow.get(Calendar.MONTH)+1));
        // comparo del String con el de Calendar
        int day2 = Integer.parseInt(date2Parts[2]);
        System.out.println("Diítas: " + day2 + "\n Debería ser igual que :" + datenow.get(Calendar.DATE));

        // Crear objeto Calendar de los dos
        Calendar cal1 = Calendar.getInstance();
        cal1.set(year1, month1, day1);
        // El segundo era completamente innecesario
        Calendar cal2 = Calendar.getInstance();
        cal2.set(year2, month2, day2);

        // Calcular la diferencia entre las dos fechas
        int years = 0;
        while (cal1.before(cal2)) {
            cal1.add(Calendar.YEAR, 1);
            if (cal1.before(cal2)) {
                years++;
            }
        }

        // Muestro la edad en años
        System.out.println("Edad: " + years + " años");
    }
}
