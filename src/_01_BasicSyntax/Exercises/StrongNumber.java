package _01_BasicSyntax.Exercises;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int number = Integer.parseInt(input);

        int sum = 0;
        int factorial = 1;
        int num = 0;

        for (int i = 0; i < input.length(); i++) {
            num = Character.getNumericValue(input.charAt(i));
            if (num == 0) {
                continue;
            }
            for (int j = 1; j <= num; j++) {
                factorial *= j;
            }
            sum += factorial;
            factorial = 1;
        }

        if (sum==number) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}
