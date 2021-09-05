package _05_Lists.Exercises;

import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int max = Math.min(firstList.size(), secondList.size());

        List<Integer> mixedList = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            mixedList.add(firstList.get(i));
            mixedList.add(secondList.get(secondList.size()-1-i));
        }

        int topLimit = 0;
        int bottomLimit = 0;
        if (firstList.size()>secondList.size()) {
            topLimit = Math.max(firstList.get(firstList.size()-2), firstList.get(firstList.size()-1));
            bottomLimit = Math.min(firstList.get(firstList.size()-2), firstList.get(firstList.size()-1));
        } else {
            topLimit = Math.max(secondList.get(0), secondList.get(1));
            bottomLimit = Math.min(secondList.get(0), secondList.get(1));
        }

        List<Integer> finalList = new ArrayList<>();
        for (int num :
                mixedList) {
            if (num < topLimit && num > bottomLimit) {
                finalList.add(num);
                }
            }

        Collections.sort(finalList);
        System.out.println(finalList.toString().replaceAll("[\\[\\],]", ""));
    }
}
