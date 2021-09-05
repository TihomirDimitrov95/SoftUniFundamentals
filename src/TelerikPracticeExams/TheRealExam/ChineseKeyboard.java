package TelerikPracticeExams.TheRealExam;

import java.util.Scanner;

public class ChineseKeyboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputWords = scanner.nextLine().split(", ");

        String topRow = "QqWwEeRrTtYyUuIiOoPp";
        String middleRow = "AaSsDdFfGgHhJjKkLl";
        String bottomRow = "ZzXxCcVvBbNnMm";

        StringBuilder wordsMeetingTheCriteria = new StringBuilder();
        for (String inputWord : inputWords) {
            if (checkIfWordIsFromOneRow(inputWord, topRow, middleRow, bottomRow)) {
                wordsMeetingTheCriteria.append(inputWord).append(", ");
            }
        }

        System.out.println(wordsMeetingTheCriteria.toString().substring(0, wordsMeetingTheCriteria.length()-2));
    }

    private static boolean checkIfWordIsFromOneRow(String inputWord, String topRow, String middleRow, String bottomRow) {
        if (checkIfSingleRow(inputWord, topRow)) {
            return true;
        } else if (checkIfSingleRow(inputWord, middleRow)) {
            return true;
        } else if (checkIfSingleRow(inputWord, bottomRow)) {
            return true;
        } else {
            return false;
        }

    }

    private static boolean checkIfSingleRow(String inputWord, String givenRow) {
        for (int i = 0; i < inputWord.length(); i++) {
            if (!givenRow.contains(Character.toString(inputWord.charAt(i)))) {
                return false;
            }
        }

        return true;
    }
}
