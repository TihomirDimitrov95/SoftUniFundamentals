package _04_Methods.Lab;

import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        switch (command) {
            case "add":
                printAdditionOfNumbers(firstNum, secondNum);
                break;
            case "divide":
                printDivisionOfNumbers(firstNum, secondNum);
                break;
            case "subtract":
                printSubtractionOfNumbers(firstNum, secondNum);
                break;
            case "multiply":
                printMultiplicationOfNumbers(firstNum,secondNum);
                break;
            default:
                System.out.println("Invalid command");
                break;
        }
    }

    private static void printAdditionOfNumbers(int firstNum, int secondNum) {
        int result = firstNum+secondNum;
        System.out.println(result);
    }

    private static void printDivisionOfNumbers(int firstNum, int secondNum) {
        int result = firstNum/secondNum;
        System.out.println(result);
    }

    private static void printSubtractionOfNumbers(int firstNum, int secondNum) {
        int result = firstNum-secondNum;
        System.out.println(result);
    }

    private static void printMultiplicationOfNumbers(int firstNum, int secondNum) {
        int result = firstNum*secondNum;
        System.out.println(result);
    }

}
