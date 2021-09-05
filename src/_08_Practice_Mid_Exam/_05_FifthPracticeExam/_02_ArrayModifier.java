package _08_Practice_Mid_Exam._05_FifthPracticeExam;

import java.util.Scanner;

public class _02_ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int[] numsArray = new int[input.length];
        for (int i = 0; i < numsArray.length; i++) {
            numsArray[i] = Integer.parseInt(input[i]);
        }

        String[] command = scanner.nextLine().split("\\s+");
        while (!command[0].equals("end")) {
            String action = command[0];

            switch (action) {
                case "swap":
                    int index1 = Integer.parseInt(command[1]);
                    int index2 = Integer.parseInt(command[2]);
                    int swap = numsArray[index1];
                    numsArray[index1] = numsArray[index2];
                    numsArray[index2] = swap;
                    break;
                case "multiply":
                    int index1multiply = Integer.parseInt(command[1]);
                    int index2multiply = Integer.parseInt(command[2]);
                    numsArray[index1multiply] = numsArray[index1multiply] * numsArray[index2multiply];
                    break;
                case "decrease":
                    for (int i = 0; i < numsArray.length; i++) {
                        numsArray[i] -= 1;
                    }
                    break;
            }
            command = scanner.nextLine().split("\\s+");
        }

        for (int i=0; i<numsArray.length; i++) {
            if (i<numsArray.length-1) {
                System.out.print(numsArray[i] + ", ");
            } else {
                System.out.print(numsArray[i]);
            }
        }

    }
}
