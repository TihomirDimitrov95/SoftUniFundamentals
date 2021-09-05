package _06_BitWise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _03_BitAtGivenPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimalNumber = Integer.parseInt(scanner.nextLine());

        int requiredBit = Integer.parseInt(scanner.nextLine());

        List<Integer> binaryNumber = new ArrayList<>();
        while (decimalNumber>0) {
            int digit = decimalNumber%2;
            binaryNumber.add(digit);
            decimalNumber/=2;
        }

        int requiredNumber = Integer.MIN_VALUE;
        if (requiredBit>=binaryNumber.size()) {
            requiredNumber=0;
        } else {
            requiredNumber = binaryNumber.get(requiredBit);
        }

        System.out.println(requiredNumber);


    }
}
