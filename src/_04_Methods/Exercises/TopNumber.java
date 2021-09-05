package _04_Methods.Exercises;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            if (checkIfTopNumber(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean checkIfTopNumber(int i) {
        boolean isDivisibleByEight = checkIfDivisibleByEight(i);
        boolean isThereOddDigit = checkIfOddDigit(i);

        boolean check = true;
        if (!isDivisibleByEight || !isThereOddDigit) {
            check = false;
        }
        return check;
    }

    private static boolean checkIfOddDigit(int i) {
        boolean isOddDigit = false;
        while (i>0) {
            int lastDigit = i%10;
            if (lastDigit % 2 == 1) {
                isOddDigit = true;
                break;
            }
            i /= 10;
        }

        return isOddDigit;
    }

    private static boolean checkIfDivisibleByEight(int i) {
        boolean isDivisible = true;
        int sum = 0;
        while (i>0) {
            int lastDigit = i%10;
            sum+=lastDigit;
            i/=10;
        }
        if (sum%8!=0){
            isDivisible = false;
        }
        return isDivisible;
    }
}
