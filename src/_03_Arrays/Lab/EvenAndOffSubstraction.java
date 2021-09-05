package _03_Arrays.Lab;

import java.util.Scanner;

public class EvenAndOffSubstraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputAsArray = input.split(" ");
        int[] numbers = new int[inputAsArray.length];

        int sumOdd = 0;
        int sumEven = 0;
        for (int indexOfArray = 0; indexOfArray < numbers.length; indexOfArray++) {
            numbers[indexOfArray] = Integer.parseInt(inputAsArray[indexOfArray]);
            if (numbers[indexOfArray]%2==0) {
                sumEven+=numbers[indexOfArray];
            } else {
                sumOdd+=numbers[indexOfArray];
            }
        }
        System.out.println(sumEven-sumOdd);
    }
}
