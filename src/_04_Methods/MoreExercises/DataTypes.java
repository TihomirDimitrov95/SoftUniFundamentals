package _04_Methods.MoreExercises;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dataType = scanner.nextLine();
        String input = scanner.nextLine();

        switch (dataType) {
            case "int":
                multiplyMethod(input);
                break;
            case "real":
                multiplyLessMethod(input);
                break;
            case "string":
                surroundMethod(input);
                break;
        }

    }

    private static void surroundMethod(String input) {
        StringBuilder output = new StringBuilder("$");
        output.append(input).append("$");
        System.out.println(output);

    }

    private static void multiplyLessMethod(String input) {
        double num = Double.parseDouble(input);
        System.out.printf("%.2f", num*1.5);
    }

    private static void multiplyMethod(String input) {
        int num = Integer.parseInt(input);
        System.out.println(num*2);
    }
}
