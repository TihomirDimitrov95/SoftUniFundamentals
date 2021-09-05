package _10_RegularExpressions.MoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "(?<string>[^0-9]{1,20})(?<repetitions>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        StringBuilder output = new StringBuilder();

        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String textToRepeat = matcher.group("string").toUpperCase();
            int repetitions = Integer.parseInt(matcher.group("repetitions"));

            StringBuilder textToAdd = new StringBuilder();
            for (int i = 0; i < repetitions; i++) {
                textToAdd.append(textToRepeat);
            }

            output.append(textToAdd);
        }

        int uniqueSymbols = getNumOfUniqueSymbols(output.toString());

        System.out.printf("Unique symbols used: %d%n%s", uniqueSymbols, output.toString());


    }

    private static int getNumOfUniqueSymbols(String finalText) {
        String uniqueSymbols = "";

        for (int i = 0; i < finalText.length(); i++) {
            if (!uniqueSymbols.contains("" + finalText.charAt(i))) {
                uniqueSymbols += "" + finalText.charAt(i);
            }
        }

        return uniqueSymbols.length();
    }
}
