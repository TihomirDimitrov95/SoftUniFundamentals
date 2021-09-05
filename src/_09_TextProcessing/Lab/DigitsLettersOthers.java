package _09_TextProcessing.Lab;

import java.util.Scanner;

public class DigitsLettersOthers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder other = new StringBuilder();

        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                digits.append(input.charAt(i));
            } else if (Character.isAlphabetic(input.charAt(i))) {
                letters.append(input.charAt(i));
            } else {
                other.append(input.charAt(i));
            }
        }

        System.out.printf("%s%n%s%n%s", digits.toString(), letters.toString(), other.toString());

    }
}
