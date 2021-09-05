package _04_Methods.Exercises;

import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        printMatrix(num);
    }

    private static void printMatrix(int num) {
        for (int i = 0; i < num; i++) {
            printLine(num);
        }
    }

    private static void printLine(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
