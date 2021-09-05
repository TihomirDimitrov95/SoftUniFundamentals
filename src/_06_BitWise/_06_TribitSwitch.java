package _06_BitWise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _06_TribitSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimalNumber = Integer.parseInt(scanner.nextLine());
        int startingPosition = Integer.parseInt(scanner.nextLine());

        List<Integer> binaryNumber = new ArrayList<>();
        while (decimalNumber>0) {
            int digit = decimalNumber%2;
            binaryNumber.add(digit);
            decimalNumber/=2;
        }

        for (int i = startingPosition; i < startingPosition+3; i++) {
            int bit = binaryNumber.get(i);
            if (bit == 0) {
                binaryNumber.set(i, 1);
            } else {
                binaryNumber.set(i, 0);
            }
        }

        for (int i = 0; i < binaryNumber.size(); i++) {
            int numberToAdd = 0;
            if (binaryNumber.get(i) == 1) {
                numberToAdd = (int) Math.pow(2, i);
            }
            decimalNumber+=numberToAdd;
        }

        System.out.println(decimalNumber);
    }
}
