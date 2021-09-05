package _02_DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        int result = 0;
        while (number>0) {
            result += number%10;
            number /= 10;
        }

        System.out.println(result);
    }
}
