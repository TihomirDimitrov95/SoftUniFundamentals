package _01_BasicSyntax.Exercises;

import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        int num = new Scanner(System.in).nextInt();
        int largestDivisible = 0;

        if (num%2==0) {
            largestDivisible = 2;
        }
        if (num%3==0) {
            largestDivisible=3;
        }
        if (num%6 == 0) {
            largestDivisible=6;
        }
        if (num%7==0) {
            largestDivisible=7;
        }
        if (num%10==0) {
            largestDivisible=10;
        }

        if (largestDivisible==0) {
            System.out.println("Not divisible");
        } else {
            System.out.printf("The number is divisible by %d", largestDivisible);
        }
    }
}
