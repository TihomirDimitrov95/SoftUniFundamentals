package _04_Methods.Exercises;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            System.out.println(checkIfPalindrome(input));
            input = scanner.nextLine();
        }
    }

    private static boolean checkIfPalindrome(String input) {
        if (input.length() == 1) {
            return true;
        }
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                return false;
            } else if (i == input.length() / 2 - 1) {
                return true;
            }
        }
        return true;
    }
}
