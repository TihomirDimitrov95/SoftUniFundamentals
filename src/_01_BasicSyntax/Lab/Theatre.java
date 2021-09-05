package _01_BasicSyntax.Lab;

import java.util.Scanner;

public class Theatre {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String typeOfDay = scanner.nextLine();
        int age = scanner.nextInt();

        if (0<=age && age <= 18) {
            switch (typeOfDay) {
                case "Weekday" -> System.out.println("12$");
                case "Weekend" -> System.out.println("15$");
                case "Holiday" -> System.out.println("5$");
                default -> System.out.println("Error!");
            }
        } else if (18 < age && age <= 64) {
            switch (typeOfDay) {
                case "Weekday" -> System.out.println("18$");
                case "Weekend" -> System.out.println("20$");
                case "Holiday" -> System.out.println("12$");
                default -> System.out.println("Error!");
            }
        } else if (64 < age && age <= 122) {
            switch (typeOfDay) {
                case "Weekday" -> System.out.println("12$");
                case "Weekend" -> System.out.println("15$");
                case "Holiday" -> System.out.println("10$");
                default -> System.out.println("Error!");
            }
        } else {
            System.out.println("Error!");
        }
    }
}
