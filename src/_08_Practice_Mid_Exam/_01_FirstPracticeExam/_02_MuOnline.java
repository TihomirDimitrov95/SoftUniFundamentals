package _08_Practice_Mid_Exam._01_FirstPracticeExam;

import java.util.Scanner;

public class _02_MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int health = 100;
        int bitcoins = 0;

        String[] dungeonRooms = scanner.nextLine().split("\\|");
        boolean isAlive = true;

        for (int i = 0; i < dungeonRooms.length; i++) {
            String command = dungeonRooms[i].split("\\s+")[0];
            int number = Integer.parseInt(dungeonRooms[i].split("\\s+")[1]);

            if (command.equals("potion")) {
                if (health+number>100) {
                    number = 100-health;
                    health = 100;
                } else {
                    health += number;
                }
                System.out.printf("You healed for %d hp.%n", number);
                System.out.printf("Current health: %d hp.%n", health);
            } else if (command.equals("chest")) {
                System.out.printf("You found %d bitcoins.%n", number);
                bitcoins += number;
            } else {
                health -= number;
                if (health<=0) {
                    System.out.printf("You died! Killed by %s.%n", command);
                    isAlive = false;
                    System.out.printf("Best room: %d%n", i+1);
                    break;
                } else {
                    System.out.printf("You slayed %s.%n", command);
                }
            }
        }

        if (isAlive) {
            System.out.printf("You've made it!%nBitcoins: %d%nHealth: %d", bitcoins, health);
        }

    }
}
