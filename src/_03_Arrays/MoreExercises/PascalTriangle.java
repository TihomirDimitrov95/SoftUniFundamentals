package _03_Arrays.MoreExercises;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        if (num==1) {
            System.out.println(1);
        } else if (num>=2) {
            int[] currentArray = new int[num];
            currentArray[0] = 1;
            System.out.println(1);

            for (int i = 2; i <= num; i++) {
                int[] printingArray = new int[num];
                printingArray[0] = 1;
                StringBuilder output = new StringBuilder();
                output.append(printingArray[0]).append(" ");
                for (int j = 1; j < printingArray.length; j++) {
                    printingArray[j] = currentArray[j] + currentArray[j-1];
                    if (printingArray[j]>0) {
                        output.append(printingArray[j]).append(" ");
                    }
                }
                System.out.println(output);

                currentArray = printingArray;
            }
        }

    }
}
