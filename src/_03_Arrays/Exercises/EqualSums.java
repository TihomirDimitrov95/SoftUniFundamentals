package _03_Arrays.Exercises;

import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        if (userInput.length()>0) {
            String[] input = userInput.split(" ");
            int[] numArray = new int[input.length];
            for (int i = 0; i < numArray.length; i++) {
                numArray[i] = Integer.parseInt(input[i]);
            }

            boolean isConditionEverMet = false;

            for (int i = 0; i < numArray.length; i++) {
                int sumToTheLeft = 0;
                if (i==1) {
                    sumToTheLeft = numArray[0];
                } else if (i>1) {
                    for (int j = 0; j < i; j++) {
                        sumToTheLeft += numArray[j];
                    }
                }

                int sumToTheRight = 0;
                if (i == numArray.length-2) {
                    sumToTheRight = numArray[numArray.length-1];
                } else if (i<numArray.length-2) {
                    for (int j = i+1; j < numArray.length; j++) {
                        sumToTheRight += numArray[j];
                    }
                }

                if (sumToTheLeft==sumToTheRight) {
                    System.out.println(i + " ");
                    isConditionEverMet = true;
                }
            }
            if (!isConditionEverMet) {
                System.out.println("no");
            }
        }
    }
}
