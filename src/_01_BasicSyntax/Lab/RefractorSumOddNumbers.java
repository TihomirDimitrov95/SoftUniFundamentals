package _01_BasicSyntax.Lab;

import java.util.Scanner;

public class RefractorSumOddNumbers {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int sum = 0;
        for (int i = 1; i <= n*2-1 ; i+=2) {
            System.out.println(i);
            sum += i;
        }
        System.out.printf("Sum: %d", sum);
    }
}
