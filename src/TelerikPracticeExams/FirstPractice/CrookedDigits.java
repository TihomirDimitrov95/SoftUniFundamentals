package TelerikPracticeExams.FirstPractice;

import java.util.Scanner;

public class CrookedDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numAsString = scanner.nextLine();
        int number = 0;

        if (numAsString.length()>1) {
            for (int i = 0; i < numAsString.length(); i++) {
                if (Character.isDigit(numAsString.charAt(i))) {
                    number += Integer.parseInt(numAsString.charAt(i) + "");
                }
            }
        } else {
            number = Integer.parseInt(numAsString);
        }

        while(number>9) {
            int updatedNumber = 0;
            while(number>0) {
                int currentDigit = number%10;
                updatedNumber += currentDigit;
                number /= 10;
            }
            number = updatedNumber;
        }

        System.out.println(number);
    }
}
