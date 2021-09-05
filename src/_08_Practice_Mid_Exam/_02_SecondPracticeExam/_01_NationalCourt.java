package _08_Practice_Mid_Exam._02_SecondPracticeExam;

import java.util.Scanner;

public class _01_NationalCourt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employeeOneEfficiency = Integer.parseInt(scanner.nextLine());
        int employeeTwoEfficiency = Integer.parseInt(scanner.nextLine());
        int employeeThreeEfficiency = Integer.parseInt(scanner.nextLine());
        int peopleCount = Integer.parseInt(scanner.nextLine());

        int peopleAnsweredPerHour = employeeOneEfficiency+employeeTwoEfficiency+employeeThreeEfficiency;
        int hoursCounter = 0;

        while (peopleCount>0) {
            peopleCount -= peopleAnsweredPerHour;
            hoursCounter++;
            if (hoursCounter%4==0) {
                hoursCounter++;
            }
        }

        System.out.printf("Time needed: %dh.", hoursCounter);


    }
}
