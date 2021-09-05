package _09_TextProcessing.Exercises;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] usernamesArray = scanner.nextLine().split(", ");

        for (String username : usernamesArray) {
            if (checkIfValidUsername(username)) {
                System.out.println(username);
            }
        }

    }

    private static boolean checkIfValidUsername(String username) {
        boolean isLengthValid = username.length()>=3 && username.length()<=16;

        boolean areSymbolsValid = true;
        for (int i = 0; i < username.length(); i++) {
            char currentChar = username.charAt(i);
            if (Character.isDigit(currentChar) || Character.isAlphabetic(currentChar) || currentChar=='-' || currentChar=='_') {
                areSymbolsValid = true;
            } else {
                areSymbolsValid = false;
                break;
            }
        }

        return isLengthValid && areSymbolsValid;
    }
}
