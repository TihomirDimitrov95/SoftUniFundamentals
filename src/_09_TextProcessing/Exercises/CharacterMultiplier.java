package _09_TextProcessing.Exercises;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split("\\s+");

        int multipliedCharacters = multiplyCharactersOfStrings(array[0], array[1]);
        System.out.println(multipliedCharacters);

    }

    private static int multiplyCharactersOfStrings(String firstWord, String secondWord) {
        int sum = 0;

        if (firstWord.length()>secondWord.length()) {
            for (int i = 0; i < secondWord.length(); i++) {
                int multiply = firstWord.charAt(i) * secondWord.charAt(i);
                sum += multiply;
            }

            for (int i = secondWord.length(); i < firstWord.length(); i++) {
                sum += firstWord.charAt(i);
            }
        } else if (firstWord.length()<secondWord.length()) {
            for (int i = 0; i < firstWord.length(); i++) {
                int multiply = firstWord.charAt(i) * secondWord.charAt(i);
                sum += multiply;
            }

            for (int i = firstWord.length(); i < secondWord.length(); i++) {
                sum += secondWord.charAt(i);
            }
        } else {
            for (int i = 0; i < secondWord.length(); i++) {
                int multiply = firstWord.charAt(i) * secondWord.charAt(i);
                sum += multiply;
            }
        }

        return sum;
    }
}
