package _03_Arrays.Exercises;

import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lengthOfSequences = Integer.parseInt(scanner.nextLine());

        int maxSequence = 0;
        String[] finalArray = new String[] {};
        int maxSum = 0;
        int maxStartingIndex = 0;
        int bestSequenceIndex = 0;
        int count = 0;

        String input = scanner.nextLine();
        while (!input.equals("Clone them!")) {
            String[] array = input.split("[!]+");
            bestSequenceIndex++;

            int longestSequence = 0;
            int currentSum = 0;
            int currentSequence = 0;
            int currentStartingIndex = 0;
            for (int i = 0; i < array.length-1; i++) {
                currentSum += Integer.parseInt(array[i]);
                if (array[i].equals("1") && array[i+1].equals("1")) {
                    currentSequence++;
                    if (currentSequence>longestSequence) {
                        longestSequence = currentSequence;
                        currentStartingIndex = i-currentSequence+1;
                    }
                } else {
                    currentSequence = 0;
                }
            }
            currentSum += Integer.parseInt(array[array.length-1]);

            if (longestSequence>maxSequence) {
                maxSequence = longestSequence;
                finalArray = array;
                maxSum = currentSum;
                maxStartingIndex = currentStartingIndex;
                count = bestSequenceIndex;
            } else if (longestSequence==maxSequence && currentStartingIndex<maxStartingIndex) {
                maxSequence = longestSequence;
                finalArray = array;
                maxSum = currentSum;
                maxStartingIndex = currentStartingIndex;
                count = bestSequenceIndex;
            } else if (longestSequence==maxSequence && currentStartingIndex==maxStartingIndex) {
                if (currentSum>maxSum) {
                    maxSequence=longestSequence;
                    finalArray = array;
                    maxSum = currentSum;
                    count = bestSequenceIndex;
                }
            }
            input = scanner.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", count, maxSum);
        System.out.println(String.join(" ", finalArray));
    }
}
