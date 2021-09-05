package _02_DataTypesAndVariables.MoreExercises;

import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            try {
                double num = Double.parseDouble(input);
                if (num%1>0) {
                    System.out.printf("%s is floating point type%n", input);
                } else {
                    System.out.printf("%s is integer type%n", input);
                }
            } catch (NumberFormatException e) {
                if (input.length()==1) {
                    System.out.printf("%s is character type%n", input);
                } else if (input.equals("true") || input.equals("false")) {
                    System.out.printf("%s is boolean type%n", input);
                } else {
                    System.out.printf("%s is string type%n", input);
                }
            }
            input = scanner.nextLine();
        }
    }
}
