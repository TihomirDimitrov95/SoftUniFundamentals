package _08_Practice_Mid_Exam._02_SecondPracticeExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> groceriesList = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());

        String[] tokens = scanner.nextLine().split("\\s+");
        while (!tokens[0].equals("Go")) {
            String command = tokens[0];

            switch (command) {
                case "Urgent":
                    String urgentItem = tokens[1];
                    if (!groceriesList.contains(urgentItem)) {
                        groceriesList.add(0, urgentItem);
                    }
                    break;
                case "Unnecessary":
                    String unnecessaryItem = tokens[1];
                    if (groceriesList.contains(unnecessaryItem)) {
                        groceriesList.remove(unnecessaryItem);
                    }
                    break;
                case "Correct":
                    String oldItem = tokens[1];
                    String newItem = tokens[2];
                    if (groceriesList.contains(oldItem)) {
                        int index = groceriesList.indexOf(oldItem);
                        groceriesList.set(index, newItem);
                    }
                    break;
                case "Rearrange":
                    String itemToRearrange = tokens[1];
                    if (groceriesList.contains(itemToRearrange)) {
                        groceriesList.remove(itemToRearrange);
                        groceriesList.add(itemToRearrange);
                    }
                    break;
            }

            tokens = scanner.nextLine().split("\\s+");
        }

        System.out.println(groceriesList.toString().replaceAll("[\\[\\]]", ""));
    }
}
