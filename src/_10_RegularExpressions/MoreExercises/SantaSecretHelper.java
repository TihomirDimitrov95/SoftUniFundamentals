package _10_RegularExpressions.MoreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantaSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());

        List<String> goodKids = new ArrayList<>();

        String encryptedMessages = scanner.nextLine();
        while(!encryptedMessages.equals("end")) {
            encryptedMessages = decryptMessage(encryptedMessages, key);

            String goodChild = checkIfGoodChild(encryptedMessages);
            if (!goodChild.equals("not a good child")) {
                goodKids.add(goodChild);
            }

            encryptedMessages = scanner.nextLine();
        }

        for (String goodKid : goodKids) {
            System.out.println(goodKid);
        }


    }

    private static String checkIfGoodChild(String encryptedMessages) {
        String output = "not a good child";

        String regex = "@(?<name>[A-Za-z]+)([^@\\-!:>]*)!(?<behaviour>[GN])!";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(encryptedMessages);

        if (matcher.find()) {
            String childName = matcher.group("name");
            String behaviour = matcher.group("behaviour");

            if (behaviour.equals("G")) {
                output = childName;
            }
        }

        return output;
    }

    private static String decryptMessage(String encryptedMessages, int key) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < encryptedMessages.length(); i++) {
            char currentChar = (char) (encryptedMessages.charAt(i) - key);
            output.append(currentChar);
        }

        return output.toString();
    }
}
