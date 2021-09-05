package _09_TextProcessing.MoreExercises;

import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfInputs = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfInputs; i++) {
            String input = scanner.nextLine();
            String name = getName(input);
            int age = getAge(input);

            System.out.printf("%s is %d years old.%n", name, age);
        }

    }

    private static int getAge(String input) {
        int startIndex = input.indexOf('#') + 1;
        int endIndex = input.indexOf('*');

        return Integer.parseInt(input.substring(startIndex, endIndex));
    }

    private static String getName(String input) {
        int startingIndex = input.indexOf('@') + 1;
        int endIndex = input.indexOf('|');

        return input.substring(startingIndex, endIndex);
    }
}
