package _09_TextProcessing.Exercises;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while(checkForRepeatedChars(input)) {
            input = removeRepeatedChars(input);
        }

        System.out.println(input);

    }

    private static String removeRepeatedChars(String input) {

        int sequenceLength = 0;
        StringBuilder sequence = new StringBuilder();
        char symbol = 0;

        for (int i = 0; i < input.length()-1; i++) {
            if (input.charAt(i)==input.charAt(i+1)) {
                sequenceLength = 2;
                symbol = input.charAt(i);

                for (int j = i+2; j < input.length(); j++) {
                    if (input.charAt(j)==symbol) {
                        sequenceLength++;
                    } else {
                        break;
                    }
                }

                break;
            }
        }

        for (int i = 0; i < sequenceLength; i++) {
            sequence.append(symbol);
        }

        String replacingValue = "" + symbol;

        input = input.replace(sequence, replacingValue);

        return input;
    }

    private static boolean checkForRepeatedChars(String input) {
        boolean check = false;

        for (int i = 0; i < input.length()-1; i++) {
            if (input.charAt(i)==input.charAt(i+1)) {
                check = true;
                break;
            }
        }

        return check;
    }
}
