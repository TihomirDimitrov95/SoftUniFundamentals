package _02_DataTypesAndVariables.MoreExercises;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfLines = Integer.parseInt(scanner.nextLine());

        boolean isBalanced = true;
        int counter = 0;

        for (int i = 0; i < numOfLines; i++) {
            String input = scanner.nextLine();
            if (input.equals("(")) {
                if (counter == 1) {
                    isBalanced = false;
                    continue;
                }
                counter++;
            }
            if (counter==1) {
                if (input.equals(")")) {
                    counter = 0;
                }
            } else {
                if (input.equals(")")) {
                    isBalanced = false;
                }
            }
        }
        if (isBalanced) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
