package _08_Practice_Mid_Exam._05_FifthPracticeExam;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int efficiencyFirst = Integer.parseInt(scanner.nextLine());
        int efficiencySecond = Integer.parseInt(scanner.nextLine());
        int efficiencyThird = Integer.parseInt(scanner.nextLine());

        int capacityPerHour = efficiencyFirst + efficiencySecond + efficiencyThird;

        int students = Integer.parseInt(scanner.nextLine());
        int hoursRequired = 0;

        while (students>0) {
            students -= capacityPerHour;
            hoursRequired++;
            if (hoursRequired%4==0) {
                hoursRequired++;
            }
        }

        System.out.printf("Time needed: %dh.", hoursRequired);

    }
}
