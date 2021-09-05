package _04_Methods.Exercises;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        int result = getSum(firstNum, secondNum);
        result = getSubtraction(result, thirdNum);

        System.out.println(result);


    }

    private static int getSubtraction(int result, int thirdNum) {
        return result-thirdNum;
    }

    private static int getSum(int firstNum, int secondNum) {
        return firstNum+secondNum;
    }
}
