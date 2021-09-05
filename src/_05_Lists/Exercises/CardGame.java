package _05_Lists.Exercises;

import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

public class CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstHand = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondHand = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());


        while (firstHand.size()!=0 && secondHand.size()!=0) {
            if (firstHand.get(0)>secondHand.get(0)) {
                executeBigger(0, firstHand, secondHand);
            } else if (secondHand.get(0)>firstHand.get(0)) {
                executeBigger(0, secondHand, firstHand);
            } else {
                firstHand.remove(0);
                secondHand.remove(0);
            }
        }

        if (firstHand.size()>0) {
            int sum = 0;
            for (int num :
                    firstHand) {
                sum+=num;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        } else {
            int sum = 0;
            for (int num :
                    secondHand) {
                sum+=num;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        }

    }

    private static void executeBigger(int index, List<Integer> winningHandList, List<Integer> losingHandList) {
        winningHandList.add(winningHandList.get(0));
        winningHandList.add(losingHandList.get(0));
        winningHandList.remove(0);
        losingHandList.remove(0);
    }
}
