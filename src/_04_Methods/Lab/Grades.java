package _04_Methods.Lab;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double grade = Double.parseDouble(scanner.nextLine());
        String mark = GetGradeInWords(grade);
        System.out.println(mark);
    }

    private static String GetGradeInWords(double grade) {
        String mark = "";
        if (grade>=2 && grade<3) {
            mark = "Fail";
        } else if (grade>=3 && grade < 3.5) {
            mark = "Poor";
        } else if (grade>=3.5 && grade<4.5) {
            mark = "Good";
        } else if (grade>=4.5 && grade<5.5) {
            mark = "Very good";
        } else if (grade>=5.5 && grade <=6) {
            mark = "Excellent";
        } else {
            mark = "Invalid input";
        }
        return mark;
    }
}
