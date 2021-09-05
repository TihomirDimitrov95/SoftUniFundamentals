package _06_BitWise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _04_BitDestroyer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimalNumber = Integer.parseInt(scanner.nextLine());
        int bitPositionToChange = Integer.parseInt(scanner.nextLine());

        List<Integer> binaryNumber = new ArrayList<>();
        while (decimalNumber>0) {
            int digit = decimalNumber%2;
            binaryNumber.add(digit);
            decimalNumber/=2;
        }

        binaryNumber.set(bitPositionToChange, 0);

        int convertedBack = 0;
        for (int i = 0; i < binaryNumber.size(); i++) {
            if (binaryNumber.get(i)==1) {
                int num = (int) Math.pow(2, i);
                convertedBack+=num;
            }
        }

        System.out.println(convertedBack);
    }
}
