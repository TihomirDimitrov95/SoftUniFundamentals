package _07_ObjectsAndClasses.Lab.BigFactorial;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        BigInteger sum = new BigInteger("1");
        for (int i = 1; i <= num; i++) {
//            sum = sum.multiply(BigInteger.valueOf(Integer.parseInt(String.valueOf(i))));
            sum = sum.multiply(BigInteger.valueOf(i));
        }

        System.out.println(sum);

    }
}
