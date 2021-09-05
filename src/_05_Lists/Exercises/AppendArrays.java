package _05_Lists.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Integer> appendedArrayList = new ArrayList<>();

        String test = input;
        int numberOfStrings = 0;
        while (test.indexOf('|')>=0) {
            test = test.substring(test.indexOf('|')+1);
            numberOfStrings++;
        }
        numberOfStrings++;

        for (int i = 0; i<numberOfStrings; i++) {
            String arrayString = "";
            if (i<numberOfStrings-1) {
                arrayString = input.substring(0, input.indexOf('|'));
            } else {
                arrayString = input;
            }
            arrayString = arrayString.trim().replaceAll(" +", " ");
            String[] array = arrayString.split("\\s+");

            for (int j = array.length-1; j >= 0; j--) {
                int currentNum = Integer.parseInt(array[j]);
                appendedArrayList.add(0, currentNum);
            }

            input = input.substring(input.indexOf('|')+1);
        }

        System.out.println(appendedArrayList.toString().replaceAll("[\\[\\],]", ""));
    }
}
