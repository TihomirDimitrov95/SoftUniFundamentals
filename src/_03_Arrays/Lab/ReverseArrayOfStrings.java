package _03_Arrays.Lab;

import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputAsArray = input.split(" ");

        for (int indexOfArray = inputAsArray.length-1; indexOfArray >= 0; indexOfArray--) {
            System.out.print(inputAsArray[indexOfArray] + " ");
        }

    }
}
