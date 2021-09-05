package _05_Lists.Lab;

import java.util.List;
import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String[] inputCommand = scanner.nextLine().split(" ");
        while(!inputCommand[0].equals("end")) {
            int number = Integer.parseInt(inputCommand[1]);
            switch (inputCommand[0]) {
                case "Add":
                    inputList.add(number);
                    break;
                case "Remove":
                    inputList.remove(Integer.valueOf(number));
                    break;
                case "RemoveAt":
                    inputList.remove(number);
                    break;
                case "Insert":
                    int indexToInsert = Integer.parseInt(inputCommand[2]);
                    inputList.add(indexToInsert, number);
                    break;
            }
            inputCommand = scanner.nextLine().split(" ");
        }

        System.out.println(inputList.toString().replaceAll("[\\[\\],]", ""));
    }
}
