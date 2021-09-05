package _02_DataTypesAndVariables.MoreExercises;

import java.util.Scanner;

public class RefractoringPrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int numbersFromTwoToGiven = 2; numbersFromTwoToGiven <= number; numbersFromTwoToGiven++) {
            boolean isPrime = true;
            for (int delimeter = 2; delimeter < numbersFromTwoToGiven; delimeter++) {
                if (numbersFromTwoToGiven%delimeter%delimeter==0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", numbersFromTwoToGiven, isPrime);
        }

    }
}
