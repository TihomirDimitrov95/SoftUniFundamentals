package _03_Arrays.Lab;

import java.util.Scanner;

public class SumEvenOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input= scanner.nextLine();
        String[] inputAsArray = input.split(" ");
        int[] numbersArray = new int[inputAsArray.length];

        int sumOdd = 0;

        for (int i = 0; i < numbersArray.length; i++) {
            numbersArray[i] = Integer.parseInt(inputAsArray[i]);
            if (numbersArray[i]%2==0) {
                sumOdd+=numbersArray[i];
            }
        }

        System.out.println(sumOdd);
    }
}
