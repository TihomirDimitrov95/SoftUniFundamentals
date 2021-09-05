package _02_DataTypesAndVariables.MoreExercises;

import java.util.Scanner;

public class DecryptifyingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder message = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char currentSymbol = scanner.nextLine().charAt(0);
            currentSymbol += key;
            message.append(currentSymbol);

        }
        System.out.println(message);
    }
}
