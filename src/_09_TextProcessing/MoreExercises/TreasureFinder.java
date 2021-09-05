package _09_TextProcessing.MoreExercises;

import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersKey = scanner.nextLine().split("\\s+");
        int[] numKey = new int[numbersKey.length];
        for (int i = 0; i < numbersKey.length; i++) {
            numKey[i] = Integer.parseInt(numbersKey[i]);
        }

        String input = scanner.nextLine();
        while(!input.equals("find")) {
            input = manipulateInput(input, numKey);

            printTreasureFound(input);

            input = scanner.nextLine();
        }


    }

    private static void printTreasureFound(String input) {
        String type = input.substring(input.indexOf('&')+1, input.lastIndexOf('&'));

        String coordinates = input.substring(input.indexOf('<')+1, input.indexOf('>'));

        System.out.printf("Found %s at %s%n", type, coordinates);

    }

    private static String manipulateInput(String input, int[] numKey) {
        StringBuilder decodedMessage = new StringBuilder();

        for (int i = 0, j = 0; i<input.length(); i++, j++) {
            if (j==numKey.length) {
                j = 0;
            }
            char currentChar = (char) (input.charAt(i) - numKey[j]);

            decodedMessage.append(currentChar);
        }

        return decodedMessage.toString();
    }
}
