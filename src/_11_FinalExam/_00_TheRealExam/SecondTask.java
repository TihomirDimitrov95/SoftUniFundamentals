package _11_FinalExam._00_TheRealExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfInputs = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfInputs; i++) {
            String message = scanner.nextLine();

            String regex = "([*@])(?<tag>[A-Z][a-z][a-z]+)\\1: (?<message>\\[[A-Za-z]\\]\\|\\[[A-Za-z+]\\]\\|\\[[A-Za-z+]\\]\\|)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(message);

            if (matcher.find()) {
                String tag = matcher.group("tag");
                String decryptedMessage = matcher.group("message");

                StringBuilder encryptedMessage = new StringBuilder();
                for (int j = 0; j < decryptedMessage.length(); j++) {
                    if (Character.isAlphabetic(decryptedMessage.charAt(j))) {
                        int asciiNumber = decryptedMessage.charAt(j);
                        encryptedMessage.append(asciiNumber).append(" ");
                    }
                }
                System.out.printf("%s: %s%n", tag, encryptedMessage);
            } else {
                System.out.println("Valid message not found!");
            }

        }

    }
}
