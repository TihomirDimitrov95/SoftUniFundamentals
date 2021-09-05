package _09_TextProcessing.Exercises;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (checkForExplosions(input)) {
            input = explodeCommand(input);
        }

        System.out.println(input);

    }

    private static String explodeCommand(String input) {

        int explosionStrength = 0;
        int startingIndex = 0;

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i)=='>' && Character.isDigit(input.charAt(i+1))) {
                startingIndex = i+1;
                explosionStrength = Integer.parseInt(input.substring(i+1, i+2));

                String sectionToDelete = input.substring(startingIndex, startingIndex+explosionStrength);
                while (checkForExplosions(sectionToDelete)) {



                }

                break;
            }
        }

        StringBuilder output = new StringBuilder(input.substring(0, startingIndex));
        output.append(input.substring(startingIndex+explosionStrength));

        return output.toString();
    }

    private static boolean checkForExplosions(String input) {
        boolean check = false;
        for (int i = 0; i < input.length()-1; i++) {
            if (input.charAt(i)=='>' && Character.isDigit(input.charAt(i+1))) {
                check = true;
                break;
            }
        }

        return check;
    }
}
