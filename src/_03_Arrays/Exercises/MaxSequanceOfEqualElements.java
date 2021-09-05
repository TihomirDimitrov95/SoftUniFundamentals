package _03_Arrays.Exercises;

import java.util.Scanner;

public class MaxSequanceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.length()>0) {
            String[] inputAsArray = input.split(" ");

            int maxSquence = 0;
            int maxSequenceEnd = 0;


            int longestSequence = 0;
            int indexEndOfLongestSequence = 0;
            for (int i = 0; i < inputAsArray.length-1; i++) {
                if (inputAsArray[i].equals(inputAsArray[i+1])) {
                    longestSequence++;
                    indexEndOfLongestSequence =  i+1;

                    if (longestSequence>maxSquence) {
                        maxSequenceEnd=indexEndOfLongestSequence;
                        maxSquence=longestSequence;
                    }
                } else {
                    longestSequence=0;
                    indexEndOfLongestSequence = 0;
                }
            }

            for (int i = maxSequenceEnd-maxSquence; i <= maxSequenceEnd; i++) {
                System.out.print(inputAsArray[i] + " ");
            }
        }
    }
}
