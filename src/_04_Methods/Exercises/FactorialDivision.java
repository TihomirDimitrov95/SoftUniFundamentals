package _04_Methods.Exercises;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        double firstFactorial = getFactorial(firstNum);
        double secondFactorial = getFactorial(secondNum);

        System.out.printf("%.2f", firstFactorial/secondFactorial);
    }

    private static double getFactorial(int num) {
        double sum = 1;
        for (int i = 1; i <= num; i++) {
            sum *= i;
        }
        return sum;
    }
}
