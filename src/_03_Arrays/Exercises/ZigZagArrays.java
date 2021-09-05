package _03_Arrays.Exercises;

import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[] firstArray = new String[n];
        String[] secondArray = new String[n];

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(" ");
            if (i%2==1) {
                firstArray[i-1] = input[0];
                secondArray[i-1] = input[1];
            } else {
                secondArray[i-1] = input[0];
                firstArray[i-1] = input[1];
            }
        }

        System.out.println(String.join(" ", firstArray));
        System.out.println(String.join(" ", secondArray));

    }
}
