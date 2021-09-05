package _02_DataTypesAndVariables.MoreExercises;

import java.util.Scanner;

public class FromLeftToRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLinesOfInput = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfLinesOfInput; i++) {
            String input = scanner.nextLine();
            int indexOfSpace = input.indexOf(" ");
            long firstNumber = Long.parseLong(input.substring(0, indexOfSpace));
            long secondNumber = Long.parseLong(input.substring(indexOfSpace+1));

            long output = 0;
            if (firstNumber>secondNumber) {
                while (firstNumber>0) {
                    long currentDigit = firstNumber%10;
                    output += currentDigit;
                    firstNumber /= 10;
                }
            } else {
                while (secondNumber>0) {
                    long currentDigit = secondNumber%10;
                    output += currentDigit;
                    secondNumber /= 10;
                }
            }
            System.out.printf("%d%n", output);
        }
    }
}
