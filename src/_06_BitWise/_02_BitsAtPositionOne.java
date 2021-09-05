package _06_BitWise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _02_BitsAtPositionOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimalNumber = Integer.parseInt(scanner.nextLine());

        List<Integer> binaryNumber = new ArrayList<>();
        while (decimalNumber>0) {
            int digit = decimalNumber%2;
            binaryNumber.add(0, digit);
            decimalNumber/=2;
        }

        int indexOfFirstBit = binaryNumber.size()-1;
        int bitAtPositionOne = binaryNumber.get(indexOfFirstBit-1);

        System.out.println(bitAtPositionOne);
    }
}
