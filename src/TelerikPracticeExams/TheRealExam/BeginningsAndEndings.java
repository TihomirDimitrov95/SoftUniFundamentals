package TelerikPracticeExams.TheRealExam;

import java.util.Scanner;

public class BeginningsAndEndings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersAsString = scanner.nextLine().split(",");
        int[] numbers = new int[numbersAsString.length];

        for (int i = 0; i < numbersAsString.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsString[i]);
        }

        int numbersToCheck = Integer.parseInt(scanner.nextLine());

        boolean check = true;
        int indexOfUnmatchingElements = 0;
        for (int i = 0; i < numbersToCheck; i++) {
            int beginningElement = numbers[i];
            int endingElement = numbers[numbers.length-1-i];

            if (beginningElement != endingElement) {
                check = false;
                indexOfUnmatchingElements = i;
                break;
            }
        }

        if (check) {
            StringBuilder matchingNumbers = new StringBuilder();
            for (int i = 0; i < numbersToCheck; i++) {
                if (i<numbersToCheck-1) {
                    matchingNumbers.append(numbers[i]).append(",");
                } else {
                    matchingNumbers.append(numbers[i]);
                }
            }

            System.out.printf("true %s", matchingNumbers.toString());
        } else {
            StringBuilder falseNumbers = new StringBuilder();
            falseNumbers.append(numbers[indexOfUnmatchingElements]).append(",").append(numbers[numbers.length-1-indexOfUnmatchingElements]);

            System.out.printf("false %s", falseNumbers.toString());
        }
    }
}
