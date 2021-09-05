package _11_FinalExam._01_FirstPracticeExam;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String activationKey = scanner.nextLine();

        String command = scanner.nextLine();
        while (!command.equals("Generate")) {
            String[] tokens = command.split(">>>");

            String typeOfCommand = tokens[0];

            switch(typeOfCommand) {
                case "Contains":
                    callContainsMethod(tokens[1], activationKey);
                    break;
                case "Flip":
                    activationKey = callFlipMethod(tokens[1], tokens[2], tokens[3], activationKey);
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    activationKey = callSliceMethod(tokens[1], tokens[2], activationKey);
                    System.out.println(activationKey);
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.printf("Your activation key is: %s", activationKey);
    }

    private static String callSliceMethod(String token, String token1, String activationKey) {
        int start = Integer.parseInt(token);
        int end = Integer.parseInt(token1);
        String sectionToRemove = activationKey.substring(start, end);
        activationKey = activationKey.replace(sectionToRemove, "");

        return activationKey;
    }

    private static String callFlipMethod(String token1, String token2, String token3, String activationKey) {
        String typeOfChange = token1;
        int startIndex = Integer.parseInt(token2);
        int endIndex = Integer.parseInt(token3);
        if (typeOfChange.equals("Upper")) {
            activationKey = flipToUpperMethod(activationKey, startIndex, endIndex);
        } else if (typeOfChange.equals("Lower")) {
            activationKey = flipToLowerMethod(activationKey, startIndex, endIndex);
        }
        return activationKey;
    }

    private static void callContainsMethod(String token, String activationKey) {
        if (activationKey.contains(token)) {
            System.out.printf("%s contains %s%n", activationKey, token);
        } else {
            System.out.println("Substring not found!");
        }
    }

    private static String flipToLowerMethod(String activationKey, int startIndex, int endIndex) {
        String oldText = activationKey.substring(startIndex, endIndex);
        String updatedText = activationKey.substring(startIndex, endIndex).toLowerCase();

        activationKey = activationKey.replace(oldText, updatedText);

        return activationKey;
    }

    private static String flipToUpperMethod(String activationKey, int startIndex, int endIndex) {
        String oldText = activationKey.substring(startIndex, endIndex);
        String updatedText = activationKey.substring(startIndex, endIndex).toUpperCase();

        activationKey = activationKey.replace(oldText, updatedText);

        return activationKey;
    }
}
