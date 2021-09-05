package _05_Lists.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        List<String> partyGuestList = new ArrayList<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = scanner.nextLine().split(" ");

            if (command.length==3) {
                if (partyGuestList.contains(command[0])) {
                    System.out.printf("%s is already in the list!%n", command[0]);
                } else {
                    partyGuestList.add(command[0]);
                }
            } else {
                if (partyGuestList.contains(command[0])) {
                    partyGuestList.remove(command[0]);
                } else {
                    System.out.printf("%s is not in the list!%n", command[0]);
                }
            }
        }

        for (String guests :
                partyGuestList) {
            System.out.println(guests);
        }
    }
}
