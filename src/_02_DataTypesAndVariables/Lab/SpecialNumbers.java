package _02_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            int sum = 0;
            int currentNumber = i;
            while (currentNumber!=0) {
                int numberToAdd = currentNumber%10;
                sum += numberToAdd;
                currentNumber /= 10;
            }
            if (sum!=5 && sum!= 7 && sum != 11) {
                System.out.printf("%d -> False\n", i);
            } else {
                System.out.printf("%d -> True\n", i);
            }
        }

    }
}
