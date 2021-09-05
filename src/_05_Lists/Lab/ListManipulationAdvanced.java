package _05_Lists.Lab;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("end")) {
            switch (command[0]) {
                case "Contains":
                    checkIfContained(command[1], numbers);
                    break;
                case "Print":
                    printList(command[1], numbers);
                    break;
                case "Get":
                    getSumOfList(numbers);
                    break;
                case "Filter":
                    filterList(command[1], command[2], numbers);
                    break;
            }

            command = scanner.nextLine().split(" ");
        }

    }

    private static void filterList(String condition, String number, List<Integer> numbers) {
        int numberToCompareAgainst = Integer.parseInt(number);

        switch (condition) {
            case "<":
                for (int nums : numbers) {
                    if (nums<numberToCompareAgainst) {
                        System.out.print(nums + " ");
                    }
                }
                break;
            case ">":
                for (int nums : numbers) {
                    if (nums>numberToCompareAgainst) {
                        System.out.print(nums + " ");
                    }
                }
                break;
            case ">=":
                for (int nums : numbers) {
                    if (nums>=numberToCompareAgainst) {
                        System.out.print(nums + " ");
                    }
                }
                break;
            case "<=":
                for (int nums : numbers) {
                    if (nums<=numberToCompareAgainst) {
                        System.out.print(nums + " ");
                    }
                }
                break;
        }
        System.out.println();
    }

    private static void getSumOfList(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum+=num;
        }
        System.out.println(sum);
    }

    private static void printList(String typeOfNumber, List<Integer> numbers) {
        switch (typeOfNumber) {
            case "even":
                for (int num : numbers) {
                    if (num % 2 == 0) {
                        System.out.print(num + " ");;
                    }
                }
                break;
            case "odd":
                for (int num : numbers) {
                    if (num%2==1) {
                        System.out.print(num + " ");
                    }
                }
        }
        System.out.println();

    }

    private static void checkIfContained(String numberSought, List<Integer> numbers) {
        int numberRequired = Integer.parseInt(numberSought);

        if (numbers.contains(numberRequired)) {
            System.out.println("Yes");
        } else {
            System.out.println("No such number");
        }
    }
}
