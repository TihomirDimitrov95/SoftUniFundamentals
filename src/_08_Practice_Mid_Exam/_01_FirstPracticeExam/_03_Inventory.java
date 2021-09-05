package _08_Practice_Mid_Exam._01_FirstPracticeExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> journalItems = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String[] tokens = scanner.nextLine().split(" - ");
        while (!tokens[0].equals("Craft!")) {
            String command = tokens[0];

            switch(command) {
                case "Collect":
                    String itemToCollect = tokens[1];
                    if (!journalItems.contains(itemToCollect)) {
                        journalItems.add(itemToCollect);
                    }
                    break;
                case "Drop":
                    String itemToDrop = tokens[1];
                    if (journalItems.contains(itemToDrop)) {
                        journalItems.remove(itemToDrop);
                    }
                    break;
                case "Combine Items":
                    String oldItem = tokens[1].split(":")[0];
                    String newItem = tokens[1].split(":")[1];
                    for (int i = 0; i < journalItems.size(); i++) {
                        if (journalItems.get(i).equals(oldItem)) {
                            journalItems.add(i+1, newItem);
                        }
                    }
                    break;
                case "Renew":
                    String itemToRenew = tokens[1];
                    if (journalItems.contains(itemToRenew)) {
                        journalItems.remove(itemToRenew);
                        journalItems.add(itemToRenew);
                    }
                    break;
            }

            tokens = scanner.nextLine().split(" - ");
        }

        String output = String.join(", ", journalItems);
        System.out.println(journalItems.toString().replaceAll("[\\[\\]]", ""));
//        System.out.println(output);

    }
}
