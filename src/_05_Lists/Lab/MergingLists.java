package _05_Lists.Lab;

import java.util.List;
import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int smallerListSize = Math.min(firstList.size(), secondList.size());

        for (int i = 0; i < smallerListSize; i++) {
            System.out.print(firstList.get(i) + " " + secondList.get(i) + " ");
        }

        printRestOfList(firstList, secondList, smallerListSize);

    }

    private static void printRestOfList(List<Integer> firstList, List<Integer> secondList, int smallerListSize) {
        if (firstList.size()>secondList.size()) {
            for (int i = smallerListSize; i < firstList.size(); i++) {
                System.out.print(firstList.get(i) + " ");
            }
        } else {
            for (int i = smallerListSize; i < secondList.size(); i++) {
                System.out.print(secondList.get(i)+ " ");
            }
        }
    }
}
