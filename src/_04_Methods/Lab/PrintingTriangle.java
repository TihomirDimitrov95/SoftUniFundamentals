package _04_Methods.Lab;

import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        printTopHalf(number);
        printBottomHalf(number);
    }

    private static void printTopHalf(int number) {
        for (int i = 0; i <=number; i++) {
            printLine(i);
        }
    }

    private static void printBottomHalf(int number) {
        for (int i = number-1; i >= 1; i--) {
            printLine(i);
        }
    }

    private static void printLine(int endOfLine) {
        for (int j = 1; j <= endOfLine; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
