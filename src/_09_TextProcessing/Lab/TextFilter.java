package _09_TextProcessing.Lab;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String textToCensore = scanner.nextLine();

        for (String bannedWord : bannedWords) {
            textToCensore = censoreForBannedWord(textToCensore, bannedWord);
        }

        System.out.println(textToCensore);

    }

    private static String censoreForBannedWord(String textToCensore, String bannedWord) {
        StringBuilder bannedWordInStars = new StringBuilder();

        for (int i = 0; i < bannedWord.length(); i++) {
            bannedWordInStars.append("*");
        }

        return textToCensore.replace(bannedWord, bannedWordInStars);
    }
}
