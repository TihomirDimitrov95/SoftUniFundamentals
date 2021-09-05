package _05_Lists.Exercises;

import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String[] commands = scanner.nextLine().split("\\s+");
        while (!commands[0].equals("End")) {
            switch(commands[0]) {
                case "Add":
                    int numberToAdd = Integer.parseInt(commands[1]);
                    numbersList.add(numberToAdd);
                    break;
                case "Insert":
                    int numbersToAdd = Integer.parseInt(commands[1]);
                    int index1 = Integer.parseInt(commands[2]);
                    if (index1>=numbersList.size() || index1<0) {
                        System.out.println("Invalid index");
                    } else {
                        numbersList.add(index1, numbersToAdd);
                    }
                    break;
                case "Remove":
                    int index2 = Integer.parseInt(commands[1]);
                    if (index2>=numbersList.size() || index2<0) {
                        System.out.println("Invalid index");
                    } else {
                        numbersList.remove(index2);
                    }

                    break;
                case "Shift":
                    int count = Integer.parseInt(commands[2]);
                    if (commands[1].equals("left")) {
                        for (int i = 0; i < count; i++) {
                            int firstVariable = numbersList.get(0);
                            numbersList.remove(0);
                            numbersList.add(firstVariable);
                        }
                    } else if (commands[1].equals("right")) {
                        for (int i = 0; i < count; i++) {
                            int lastVariable = numbersList.get(numbersList.size()-1);
                            numbersList.remove(numbersList.size()-1);
                            numbersList.add(0, lastVariable);
                        }

                    }
                    break;
            }
            commands = scanner.nextLine().split(" ");
        }

        System.out.println(numbersList.toString().replaceAll("[\\[\\],]", ""));
    }
}
