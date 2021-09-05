package _08_Practice_Mid_Exam._06_SixthPracticeExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleWaitingForLift = Integer.parseInt(scanner.nextLine());
        List<Integer> currentLiftStateList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < currentLiftStateList.size(); i++) {
            int availableSpaces = 0;
            if (currentLiftStateList.get(i)<4) {
                availableSpaces = 4-currentLiftStateList.get(i);
            }

            if (peopleWaitingForLift>0 && peopleWaitingForLift>availableSpaces) {
                peopleWaitingForLift -= availableSpaces;
                currentLiftStateList.set(i, 4);
            } else if (peopleWaitingForLift>0 && peopleWaitingForLift<=availableSpaces) {
                int newValue = currentLiftStateList.get(i) + peopleWaitingForLift;
                currentLiftStateList.set(i, newValue);
                peopleWaitingForLift = 0;
                break;
            }
        }

        if (currentLiftStateList.get(currentLiftStateList.size()-1) < 4 && peopleWaitingForLift==0) {
            System.out.println("The lift has empty spots!");
        } else if (currentLiftStateList.get(currentLiftStateList.size()-1)==4 && peopleWaitingForLift>0){
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaitingForLift);
        }
        System.out.println(currentLiftStateList.toString().replaceAll("[\\[\\],]", ""));
    }
}
