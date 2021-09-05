package _01_BasicSyntax.Lab;

import java.util.Scanner;

public class Passed {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        double grade = scanner.nextDouble();

        if (grade>=3.00) {
            System.out.println("Passed!");
        }

    }
}
