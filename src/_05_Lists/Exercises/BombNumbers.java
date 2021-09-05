package _05_Lists.Exercises;

import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numberSequence = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> specialNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 0; i < numberSequence.size(); i++) {
            if (numberSequence.get(i).equals(specialNumbers.get(0))) {
                denotateList(i, numberSequence, specialNumbers.get(1));
            }
        }

        int sum = 0;
        for (int num : numberSequence) {
            sum+=num;
        }

        System.out.println(sum);



    }

    private static void denotateList(int startingIndex, List<Integer> numberSequence, int power) {
        denoteRight(startingIndex, numberSequence, power);

        int indexToDenoteLeft = 0;
        if (startingIndex==numberSequence.size()-1) {
            indexToDenoteLeft = startingIndex-1;
        } else {
            indexToDenoteLeft = startingIndex;
        }
        numberSequence.remove(startingIndex);

        denoteLeft(indexToDenoteLeft, numberSequence, power);
    }

    private static void denoteLeft(int startingIndex, List<Integer> numberSequence, int power) {
        if (startingIndex-power < 0) {
            for (int index = startingIndex; index >= 0; index--) {
                numberSequence.remove(index);
            }
        } else {
            for (int index = startingIndex; index > startingIndex-power; index--) {
                numberSequence.remove(index);
            }
        }


    }

    private static void denoteRight(int startingIndex, List<Integer> numberSequence, int power) {
        if (startingIndex+power > numberSequence.size()) {
            for (int index = startingIndex+1; index < numberSequence.size(); index++) {
                numberSequence.remove(index);
            }
        } else {
            for (int index = startingIndex+1; index <= startingIndex+power; index++) {
                numberSequence.remove(index);
            }
        }


    }
}
