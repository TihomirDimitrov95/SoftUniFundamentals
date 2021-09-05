package _05_Lists.Exercises;

import java.util.List;
import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] command = scanner.nextLine().split(" ");
        while(!command[0].equals("end")) {
            switch (command[0]) {
                case "Delete":
                    deleteFromlist(command[1], numbersList);
                    break;
                case "Insert":
                    insertInTheList(command[1], command[2], numbersList);
                    break;
            }
            command = scanner.nextLine().split(" ");
        }

        System.out.println(numbersList.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void insertInTheList(String num1, String num2, List<Integer> numbersList) {
        int element = Integer.parseInt(num1);
        int position = Integer.parseInt(num2);

        numbersList.add(position, element);
    }

    private static void deleteFromlist(String num, List<Integer> numbersList) {
        int numberToDelete = Integer.parseInt(num);
        for (int i = 0; i < numbersList.size(); i++) {
            if (numbersList.get(i) == numberToDelete) {
                numbersList.remove(i);
            }
        }
    }
}
