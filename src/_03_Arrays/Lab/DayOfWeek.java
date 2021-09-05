package _03_Arrays.Lab;

import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] daysOfTheWeek = new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        int dayRequested = Integer.parseInt(scanner.nextLine());

        if (dayRequested>=1 && dayRequested<=7) {
            System.out.println(daysOfTheWeek[dayRequested-1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
