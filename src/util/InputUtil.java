package util;

import java.util.Scanner;

public class InputUtil {
    public static int inputInt(String tittle){
        Scanner scanner = new Scanner(System.in);
        System.out.println(tittle);
        return scanner.nextInt();
    }

    public static long inputLong(String tittle){
        Scanner scanner = new Scanner(System.in);
        System.out.println(tittle);
        return scanner.nextLong();
    }


    public static double inputDouble(String tittle){
        Scanner scanner = new Scanner(System.in);
        System.out.println(tittle);
        return scanner.nextDouble();
    }

    public static String inputString(String tittle){
        Scanner scanner = new Scanner(System.in);
        System.out.println(tittle);
        return scanner.nextLine();
    }
}
