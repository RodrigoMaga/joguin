package br.com.ragnainterprise.helpers;

import java.util.Scanner;

public class InputUserTerminal {
    public static String askString(String input) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(input);
        return scanner.next();
    }

    public static int askInt(String input) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(input);
        return scanner.nextInt();
    }
}
