package _09_TextProcessing.MoreExercises;

import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] wordsInMorse = scanner.nextLine().split("\\s+");

        StringBuilder decodedMessage = new StringBuilder();

        for (String wordToTranslate : wordsInMorse) {
            String translatedWord = translateFromMorse(wordToTranslate);
            decodedMessage.append(translatedWord);
        }

        System.out.println(decodedMessage);

    }

    private static String translateFromMorse(String wordToTranslate) {

        for (int i = 0; i < wordToTranslate.length(); i++) {
            char currentChar = wordToTranslate.charAt(i);

        }

        return null;
    }
}
