package _04_Methods.Lab;

import java.util.Scanner;

public class SignOfInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        String signOfNumber = GetSignOfInteger(number);
        System.out.printf("The number %d is %s.", number, signOfNumber);
    }

    public static String GetSignOfInteger (int num) {
        String sign = "";
        if (num>0) {
            sign = "positive";
        } else if (num < 0) {
            sign = "negative";
        } else {
            sign = "zero";
        }
        return sign;
    }
}
