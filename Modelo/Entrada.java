package Modelo;

import java.util.InputMismatchException;
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
        try {

            num = sc.nextInt();

        } catch (InputMismatchException e) {
            System.out.println(e + " Debe ser numero");
        } finally {
            sc.nextLine();
        }

        return num;

    }
}