package br.com.ragnainterprise.helper;

import java.util.Scanner;

public class InputUserTerminal {
    public static String askString(String input) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf(input);
        String userInput = scanner.nextLine();
        if (!userInput.isBlank()) {
            return userInput;
        }
        return askString(input);
    }

    public static int askInt(String input) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf(input);
        return scanner.nextInt();
    }
}
