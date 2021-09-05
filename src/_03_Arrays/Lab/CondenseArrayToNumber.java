package _03_Arrays.Lab;

import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputAsArray = input.split(" ");
        int[] array = new int[inputAsArray.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(inputAsArray[i]);
        }

        while (array.length>1) {
            int[] condensed = new int[array.length-1];
            for (int i = 0; i < condensed.length; i++) {
                condensed[i] = array[i] + array[i+1];
            }
            array = condensed;
        }
        System.out.println(array[0]);

    }
}
