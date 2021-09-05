package _05_Lists.Exercises;

import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

public class AnnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputList = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String[] command = scanner.nextLine().split(" ");

        while(!command[0].equals("3:1")) {

            switch(command[0]) {
                case "merge":
                    int startIndex = Integer.parseInt(command[1]);
                    int endIndex = Integer.parseInt(command[2]);
                    mergeCommand(startIndex, endIndex, inputList);
                    break;
                case "divide":
                    int index = Integer.parseInt(command[1]);
                    int partitions = Integer.parseInt(command[2]);
                    divideCommand(index, partitions, inputList);
                    break;

            }
            command = scanner.nextLine().split(" ");
        }

        System.out.println(inputList.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void divideCommand(int index, int partitions, List<String> inputList) {
        if (index<0) {
            index =0;
        }
        if (index>= inputList.size()) {
            index = inputList.size()-1;
        }

        String original = inputList.get(index);

        int averageElementLength = original.length()/partitions;
        int lastElement = 0;
        if (original.length()%partitions!=0) {
            lastElement = original.length()/partitions + original.length()%partitions;
        }

        List<String> newList = new ArrayList<>();
        for (int i = 0; i < partitions; i++) {
            if (i<partitions-1) {
                String elementToAdd = original.substring(0, averageElementLength);
                newList.add(elementToAdd);
            } else {
                newList.add(original);
            }
            original = original.substring(averageElementLength);
        }

        for (int i = 0; i < partitions; i++) {
            if (i==0) {
                inputList.set(index, newList.get(i));
            } else {
                inputList.add(index+i, newList.get(i));
            }
        }



    }

    private static void mergeCommand(int startIndex, int endIndex, List<String> inputList) {
        if (startIndex<0) {
            startIndex = 0;
        }
        if (endIndex>=inputList.size()) {
            endIndex=inputList.size()-1;
        }

        StringBuilder input = new StringBuilder();
        for (int i = startIndex; i <= endIndex; i++) {
            input.append(inputList.get(i));
        }

        for (int i = startIndex; i <= endIndex; i++) {
            if (i==startIndex) {
                inputList.set(i, input.toString());
            } else {
                inputList.remove(startIndex+1);
            }
        }
    }
}
