package _09_TextProcessing.Exercises;

import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger bigNumber = new BigInteger(scanner.nextLine());
        short smallNumber = Short.parseShort(scanner.nextLine());

        bigNumber = bigNumber.multiply(BigInteger.valueOf(smallNumber));

        System.out.println(bigNumber);

    }
}
