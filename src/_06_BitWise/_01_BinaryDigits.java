package _06_BitWise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _01_BinaryDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int binaryDigit = Integer.parseInt(scanner.nextLine());
        double testVariable = 2.14;
        double anotherChange = 2.144;


        List<Integer> convertedNumber = new ArrayList<>();
        while (number>0) {
            int digit = number%2;
            convertedNumber.add(0, digit);
            number/=2;
        }

        int count = 0;
        for (int num : convertedNumber) {
            if (num == binaryDigit) {
                count++;
            }
        }

        System.out.println(count);
    }
}
