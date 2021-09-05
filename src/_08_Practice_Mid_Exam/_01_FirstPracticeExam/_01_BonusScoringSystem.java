package _08_Practice_Mid_Exam._01_FirstPracticeExam;

import java.util.Scanner;

public class _01_BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentsCount = Integer.parseInt(scanner.nextLine());
        int lecturesCount = Integer.parseInt(scanner.nextLine());
        int initialBonus = Integer.parseInt(scanner.nextLine());

        double maxBonus = 0;
        int studentAttendances = 0;

        for (int i = 0; i < studentsCount; i++) {
            int currentStudentAttendances = Integer.parseInt(scanner.nextLine());
            double bonus = (currentStudentAttendances*1.0)/lecturesCount*(5+initialBonus);

            if (bonus>maxBonus) {
                maxBonus = bonus;
                studentAttendances = currentStudentAttendances;
            }
        }

        int roundedBonus = (int) Math.ceil(maxBonus);
        System.out.printf("Max Bonus: %d.%n", roundedBonus);
        System.out.printf("The student has attended %d lectures.", studentAttendances);

    }
}
