package _04_Methods.Exercises;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String middleChars = getMiddleCharacters(input);

        System.out.println(middleChars);
    }

    private static String getMiddleCharacters(String input) {
        StringBuilder output = new StringBuilder();
        if (input.length()%2==0) {
            output.append(input.charAt(input.length()/2-1)).append(input.charAt(input.length()/2));
        } else {
            output.append(input.charAt(input.length()/2));
        }
        return output.toString();
    }
}
