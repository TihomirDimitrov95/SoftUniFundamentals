package _02_DataTypesAndVariables.MoreExercises;

import java.math.BigDecimal;
import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal firstNumber = new BigDecimal(scanner.nextLine());
        BigDecimal secondNumber = new BigDecimal(scanner.nextLine());

        if (firstNumber==secondNumber) {
            System.out.println("True");
        } else {
            firstNumber = firstNumber.subtract(secondNumber);
            BigDecimal allowedDifference = new BigDecimal(0.0000001);
            if (firstNumber.compareTo(allowedDifference)==1) {
                System.out.println("False");
            } else {
                System.out.println("True");
            }
        }

    }
}
