package _02_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class ConcatNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        String secondName = scanner.nextLine();
        String delimeter = scanner.nextLine();

        StringBuilder output = new StringBuilder();
        output.append(firstName).append(delimeter).append(secondName);

        System.out.println(output);
    }
}
