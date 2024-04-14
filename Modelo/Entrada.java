package Modelo;
import java.util.Scanner;

public class Entrada {
    static Scanner sc = new Scanner(System.in);

    public static String leerString() {
        String sb = "";
        sb = sc.nextLine();
        return sb;

    }

    public static int leerEntero() {
        int num = 0;
        num = sc.nextInt();

        sc.nextLine(); 
        return num;

    }
}