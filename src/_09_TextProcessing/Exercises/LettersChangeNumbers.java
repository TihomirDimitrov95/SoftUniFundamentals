package _09_TextProcessing.Exercises;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        double sum = 0;

        for (String word : input) {
            double result = executeOperation(word);

            sum += result;
        }

        System.out.printf("%.2f", sum);

    }

    private static double executeOperation(String word) {
        char firstLetter = word.charAt(0);
        char secondLetter = word.charAt(word.length()-1);

        double num = Double.parseDouble(word.substring(1, word.length()-1));

        if (Character.isUpperCase(firstLetter)) {
            num /= (firstLetter-64);
        } else {
            num *= (firstLetter-96);
        }

        if (Character.isUpperCase(secondLetter)) {
            num -= (secondLetter-64);
        } else {
            num += (secondLetter-96);
        }

        return num;
    }
}
