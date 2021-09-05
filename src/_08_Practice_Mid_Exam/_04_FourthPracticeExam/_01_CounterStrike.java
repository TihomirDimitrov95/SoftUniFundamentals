package _08_Practice_Mid_Exam._04_FourthPracticeExam;

import java.util.Scanner;

public class _01_CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialEnergy = Integer.parseInt(scanner.nextLine());
        int wonBattles = 0;

        String command = scanner.nextLine();
        boolean wonGame = true;
        while (!command.equals("End of battle")) {
            int distanceRequired = Integer.parseInt(command);

            if (initialEnergy - distanceRequired >=0) {
                initialEnergy -= distanceRequired;
                wonBattles++;
                if (wonBattles%3==0) {
                    initialEnergy += wonBattles;
                }
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", wonBattles, initialEnergy);;
                wonGame = false;
                break;
            }

            command = scanner.nextLine();
        }

        if (wonGame) {
            System.out.printf("Won battles: %d. Energy left: %d", wonBattles, initialEnergy);
        }


    }
}
