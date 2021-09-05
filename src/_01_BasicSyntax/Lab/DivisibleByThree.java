package _01_BasicSyntax.Lab;

import java.util.Scanner;

public class DivisibleByThree {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 3; i <= 100; i+=3) {
            System.out.println(i);
        }
    }
}
