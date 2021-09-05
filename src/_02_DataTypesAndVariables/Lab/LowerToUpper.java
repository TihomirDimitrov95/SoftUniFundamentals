package _02_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class LowerToUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstCharToTest = scanner.nextLine().charAt(0);

        if (65<=firstCharToTest && firstCharToTest<=90) {
            System.out.println("upper-case");
        } else {
            System.out.println("lower-case");
        }

    }
}
