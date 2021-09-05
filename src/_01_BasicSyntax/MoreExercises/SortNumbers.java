package _01_BasicSyntax.MoreExercises;

import java.util.Scanner;

public class SortNumbers {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        if (firstNum>=secondNum && firstNum>=thirdNum) {
            System.out.println(firstNum);
            if (secondNum>=thirdNum) {
                System.out.printf("%d%n%d", secondNum, thirdNum);
            } else {
                System.out.printf("%d%n%d", thirdNum, secondNum);
            }
        } else if (secondNum>=firstNum && secondNum>=thirdNum){
            System.out.println(secondNum);
            if (firstNum>=thirdNum) {
                System.out.printf("%d%n%d", firstNum, thirdNum);
            } else {
                System.out.printf("%d%n%d", thirdNum, firstNum);
            }
        } else {
            System.out.println(thirdNum);
            if (firstNum>=secondNum) {
                System.out.printf("%d%n%d", firstNum, secondNum);
            } else {
                System.out.printf("%d%n%d", secondNum, firstNum);
            }
        }

    }
}
