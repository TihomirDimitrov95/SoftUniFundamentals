package _04_Methods.Lab;

import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        char commandSing = scanner.nextLine().charAt(0);
        int secondNum = Integer.parseInt(scanner.nextLine());

        int result = 0;

        switch (commandSing) {
            case '+':
                result = addNumbers(firstNum, secondNum);
                break;
            case '-':
                result = subtractNumbers(firstNum, secondNum);
                break;
            case '*':
                result = multiplyNumbers(firstNum, secondNum);
                break;
            case '/':
                result = divideNumbers(firstNum,secondNum);
                break;
            default:
                System.out.println("Invalid input");
                break;
        }

        System.out.println(result);
    }

    private static int divideNumbers(int firstNum, int secondNum) {
        return firstNum/secondNum;
    }

    private static int multiplyNumbers(int firstNum, int secondNum) {
        return firstNum*secondNum;
    }

    private static int subtractNumbers(int firstNum, int secondNum) {
        return firstNum-secondNum;
    }

    private static int addNumbers(int firstNum, int secondNum) {
        return firstNum+secondNum;
    }
}
