package _03_Arrays.Exercises;

import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.length()>0) {
            int magicNumber = Integer.parseInt(scanner.nextLine());

            String[] array = input.split(" ");
            int[] numsArray = new int[array.length];
            for (int i = 0; i < numsArray.length; i++) {
                numsArray[i] = Integer.parseInt(array[i]);
            }

            for (int i = 0; i < numsArray.length-1; i++) {
                for (int j = i+1; j < numsArray.length; j++) {
                    if (numsArray[i] + numsArray[j] == magicNumber) {
                        System.out.printf("%d %d%n", numsArray[i], numsArray[j]);
                    }
                }
            }
        }
    }
}
