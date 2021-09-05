package _04_Methods.Exercises;

import java.util.Scanner;

public class SmallestOfThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        int smallest = getSmallestNum(firstNum, secondNum, thirdNum);
        System.out.println(smallest);

    }

    private static int getSmallestNum(int firstNum, int secondNum, int thirdNum) {
        if (firstNum<secondNum && firstNum<thirdNum) {
            return firstNum;
        } else if (secondNum<firstNum && secondNum<thirdNum) {
            return secondNum;
        } else if (thirdNum<secondNum && thirdNum<firstNum) {
            return thirdNum;
        } else {
            return firstNum;
        }
    }
}
