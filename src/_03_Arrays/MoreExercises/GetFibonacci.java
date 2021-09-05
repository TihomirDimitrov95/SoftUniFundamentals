package _03_Arrays.MoreExercises;

import java.util.Scanner;

public class GetFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wantedNumber = Integer.parseInt(scanner.nextLine());

        int[] arrayOfFibonacci = new int[wantedNumber];
        arrayOfFibonacci[0] = 1;

        if (wantedNumber<=2) {
            System.out.println(1);
        } else {
            for (int i = 1; i < arrayOfFibonacci.length; i++) {
                if (i==1) {
                    arrayOfFibonacci[i] = 1;
                } else {
                    arrayOfFibonacci[i] = arrayOfFibonacci[i-1] +arrayOfFibonacci[i-2];
                }
            }
            System.out.println(arrayOfFibonacci[wantedNumber-1]);
        }
    }
}
