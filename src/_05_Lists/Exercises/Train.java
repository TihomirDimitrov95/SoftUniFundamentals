package _05_Lists.Exercises;

import java.util.List;
import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int maxCapacityForWagon = Integer.parseInt(scanner.nextLine());

        String[] inputCommand = scanner.nextLine().split(" ");
        while (!inputCommand[0].equals("end")) {
            switch (inputCommand[0]) {
                case "Add":
                    int passengersInNewWagon = Integer.parseInt(inputCommand[1]);
                    if (passengersInNewWagon>maxCapacityForWagon) {
                        inputList.add(maxCapacityForWagon);
                    } else {
                        inputList.add(passengersInNewWagon);
                    }
                    break;
                default:
                    int passengersToAdd = Integer.parseInt(inputCommand[0]);
                    for (int i = 0; i < inputList.size(); i++) {
                        int sum = inputList.get(i)+passengersToAdd;
                        if (sum<=maxCapacityForWagon) {
                            inputList.set(i, sum);
                            break;
                        }
                    }
                    break;
            }

            inputCommand = scanner.nextLine().split(" ");
        }


        System.out.println(inputList.toString().replaceAll("[\\[\\],]", ""));


    }
}
