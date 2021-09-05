package _04_Methods.Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());

        double output = mathPower(number, power);
        System.out.println(new DecimalFormat("0.####").format(output));

    }

    private static double mathPower(double number, int power) {
        double sum = number;
        for (int i = 0; i < power-1; i++) {
            sum *= number;
        }
        return sum;
    }
}
