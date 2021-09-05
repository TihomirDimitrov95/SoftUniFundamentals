package _01_BasicSyntax.Lab;

import java.util.Scanner;

public class MultiplicationTableTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int number = scanner.nextInt();
        int multiplier = scanner.nextInt();
        if (multiplier>10) {
            System.out.printf("%d X %d = %d", number, multiplier, number*multiplier);
        } else {
            for (int i = multiplier; i <= 10; i++) {
                System.out.printf("%d X %d = %d%n", number, i, number*i);
            }
        }
    }
}
