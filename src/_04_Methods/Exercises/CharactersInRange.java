package _04_Methods.Exercises;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);

        String charactersInRange = getCharactersInRange(firstChar, secondChar);
        System.out.println(charactersInRange);


    }

    private static String getCharactersInRange(char firstChar, char secondChar) {
        StringBuilder output = new StringBuilder();
        if (firstChar<secondChar) {
            for (char currentChar = firstChar; currentChar < secondChar; currentChar++) {
                if (currentChar!=firstChar) {
                    output.append(currentChar).append(" ");
                }
            }
        } else {
            for (char currentChar = secondChar; currentChar < firstChar; currentChar++) {
                if (currentChar!=secondChar) {
                    output.append(currentChar).append(" ");
                }
            }
        }

        return output.toString();
    }
}
