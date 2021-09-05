package _04_Methods.MoreExercises;

import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        String multiplicationSign = getSign(num1, num2, num3);
        System.out.println(multiplicationSign);
    }

    private static String getSign(int num1, int num2, int num3) {
        String output = "";
        if (num1==0 || num2 ==0 || num3==0) {
            output = "zero";
        } else if (checkIfPositive(num1, num2, num3)) {
            output = "positive";
        } else {
            output = "negative";
        }

        return output;
    }

    private static boolean checkIfPositive(int num1, int num2, int num3) {
        boolean isPositive = false;
        if (num1<0 && num2<0 && num3>0) {
            isPositive = true;
        } else if (num1>0 && num2>0 && num3>0) {
            isPositive = true;
        } else if (num1>0 && num2<0 && num3<0) {
            isPositive = true;
        } else if (num1<0 && num2>0 && num3<0) {
            isPositive = true;
        }

        return isPositive;
    }
}
