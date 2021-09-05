package _08_Practice_Mid_Exam._02_SecondPracticeExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> neighbourhoodList = Arrays.stream(scanner.nextLine().split("@")).map(Integer::parseInt).collect(Collectors.toList());
        int cupidPosition = 0;

        String command = scanner.nextLine();
        while (!command.equals("Love!")) {
            int length = Integer.parseInt(command.split("\\s+")[1]);

            cupidPosition+=length;
            if (cupidPosition>=neighbourhoodList.size()) {
                cupidPosition = 0;
            }

            if (neighbourhoodList.get(cupidPosition)==0) {
                System.out.printf("Place %d already had Valentine's day.%n", cupidPosition);
            } else {
                int newValue = neighbourhoodList.get(cupidPosition) - 2;
                if (newValue == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", cupidPosition);
                }
                neighbourhoodList.set(cupidPosition, newValue);
            }

            command = scanner.nextLine();
        }

        boolean isMissionSuccessful = true;
        int count = 0;
        for (int house : neighbourhoodList) {
            if (house > 0) {
                isMissionSuccessful = false;
                count++;
            }
        }

        System.out.printf("Cupid's last position was %d.%n", cupidPosition);
        if (isMissionSuccessful) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", count);
        }

    }
}
