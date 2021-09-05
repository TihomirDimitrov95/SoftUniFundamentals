package _03_Arrays.Exercises;

import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputAsString = scanner.nextLine().split(" ");
        int[] array = new int[inputAsString.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(inputAsString[i]);
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < array.length-1; i++) {
            boolean isBigger = true;
            for (int j = i+1; j < array.length; j++) {
                if (array[j]>=array[i]) {
                    isBigger = false;
                    break;
                }
            }
            if (isBigger) {
                output.append(array[i]).append(" ");
            }
        }
        output.append(array[array.length-1]);
        System.out.println(output);
    }
}
