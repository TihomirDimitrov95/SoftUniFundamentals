package _09_TextProcessing.MoreExercises;

import java.util.Scanner;

public class ASCII_Sumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char beginningChar = scanner.nextLine().charAt(0);
        char endingChar = scanner.nextLine().charAt(0);

        String randomInput = scanner.nextLine();

        int sum = getSum(beginningChar, endingChar, randomInput);

        System.out.println(sum);

    }

    private static int getSum(char beginningChar, char endingChar, String randomInput) {
        int result = 0;

        for (int i = 0; i < randomInput.length(); i++) {
            if (randomInput.charAt(i)> beginningChar && randomInput.charAt(i) < endingChar) {
                result += randomInput.charAt(i);
            }
        }

        return result;
    }
}
