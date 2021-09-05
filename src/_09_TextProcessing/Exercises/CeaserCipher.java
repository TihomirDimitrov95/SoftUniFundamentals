package _09_TextProcessing.Exercises;

import java.util.Scanner;

public class CeaserCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] originalText = scanner.nextLine().toCharArray();

        encryptText(originalText);

        for (char c : originalText) {
            System.out.print(c);
        };

    }

    private static void encryptText(char[] originalText) {

        for (int i = 0; i < originalText.length; i++) {
            char shift = 3;
            char updatedChar = (char) (originalText[i]+shift);
            originalText[i] = updatedChar;
        }
    }
}
