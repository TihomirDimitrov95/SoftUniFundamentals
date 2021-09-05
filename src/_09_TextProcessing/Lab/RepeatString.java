package _09_TextProcessing.Lab;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrayOfStrings = scanner.nextLine().split("\\s+");

        StringBuilder repeatedWords = new StringBuilder();
        for (String word : arrayOfStrings) {
            repeatedWords.append(repeatWordMethod(word, word.length()));
        }

        System.out.println(repeatedWords);

    }

    private static String repeatWordMethod(String word, int repetitionsRequired) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < repetitionsRequired; i++) {
            output.append(word);
        }

        return output.toString();
    }
}
