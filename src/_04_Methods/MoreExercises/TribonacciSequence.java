package _04_Methods.MoreExercises;

import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        String output = getTribonacciSequence(num);
        System.out.println(output);
    }

    private static String getTribonacciSequence(int num) {

        StringBuilder output = new StringBuilder();
        int[] array = new int[num];
        if (num>=3) {
            array[0] = 1;
            array[1] = 1;
            array[2] = 2;
            for (int i = 3; i < num; i++) {
                array[i] = array[i-3]+array[i-2]+array[i-1];
            }
        } else if (num==2) {
            array[0] = 1;
            array[1] = 1;
        } else if (num==1) {
            array[0] = 1;
        }
        for (int number :
                array) {
            output.append(number).append(" ");
        }

        return output.toString();
    }
}
