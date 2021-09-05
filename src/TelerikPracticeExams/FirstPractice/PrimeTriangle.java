package TelerikPracticeExams.FirstPractice;

import java.util.Scanner;

public class PrimeTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        StringBuilder outputLine = new StringBuilder();

        for (int i = 1; i <= number; i++) {
            if (checkIfPrime(i)) {
                outputLine.append(1);
            } else {
                outputLine.append(0);
            }

            if (checkIfPrime(i)) {
                System.out.println(outputLine);
            }
        }
    }

    private static boolean checkIfPrime(int number) {
        boolean isPrime = true;

        for (int i = 2; i < number; i++) {
            if (number%i==0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}
