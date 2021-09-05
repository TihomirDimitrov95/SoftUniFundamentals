package _01_BasicSyntax.Lab;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main (String[] args) {
        int number = new Scanner(System.in).nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d X %d = %d%n", number, i, number*i);
        }
    }
}
