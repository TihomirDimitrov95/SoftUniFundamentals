package TelerikPracticeExams.FirstPractice;

import java.util.Scanner;

public class BalancedNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sumOfBalanced = 0;

        int number = Integer.parseInt(scanner.nextLine());
        while (checkIfBalanced(number)) {
            sumOfBalanced += number;
            number = Integer.parseInt(scanner.nextLine());
        }

        System.out.println(sumOfBalanced);
    }

    private static boolean checkIfBalanced(int number) {
        boolean isBalanced = true;

        if (number>999 || number <100) {
            isBalanced = false;
        } else {
            int firstDigit = number/100;
            int secondDigit = (number%100)/10;
            int thirdDigit = number%10;

            if (firstDigit+thirdDigit != secondDigit) {
                isBalanced = false;
            }
        }

        return isBalanced;
    }
}
