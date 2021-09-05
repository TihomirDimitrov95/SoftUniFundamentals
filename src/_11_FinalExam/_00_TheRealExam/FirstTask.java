package _11_FinalExam._00_TheRealExam;

import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String initialString = scanner.nextLine();

        String[] command = scanner.nextLine().split("\\s+");
        while (!command[0].equals("Finish")) {
            String typeOfCommand = command[0];

            switch(typeOfCommand) {
                case "Replace":
                    String currentChar = command[1];
                    String newChar = command[2];
                    initialString = initialString.replaceAll(currentChar, newChar);
                    System.out.println(initialString);
                    break;
                case "Cut":
                    if (!Character.isDigit(command[1].charAt(0)) || !Character.isDigit(command[2].charAt(0))) {
                        System.out.println("Invalid indices!");
                        break;
                    }
                    int startIndex = Integer.parseInt(command[1]);
                    int endIndex = Integer.parseInt(command[2]);

                    if (startIndex < 0 || startIndex >= initialString.length() || endIndex < 0 || endIndex >= initialString.length() || startIndex> endIndex) {
                        System.out.println("Invalid indices!");
                    } else {
                        String sectionToRemove = initialString.substring(startIndex, endIndex+1);
                        initialString = initialString.replace(sectionToRemove, "");
                        System.out.println(initialString);
                    }
                    break;
                case "Make":
                    String changeLetters = command[1];
                    if (changeLetters.equals("Upper")) {
                        initialString = initialString.toUpperCase();
                    } else if (changeLetters.equals("Lower")) {
                        initialString = initialString.toLowerCase();
                    }
                    System.out.println(initialString);
                    break;
                case "Check":
                    String message = command[1];
                    if (initialString.contains(message)) {
                        System.out.printf("Message contains %s%n", message);
                    } else {
                        System.out.printf("Message doesn't contain %s%n", message);
                    }
                    break;
                case "Sum":
                    if (!Character.isDigit(command[1].charAt(0)) || !Character.isDigit(command[2].charAt(0))) {
                        System.out.println("Invalid indices!");
                        break;
                    }
                    int startingIndex = Integer.parseInt(command[1]);
                    int endingIndex = Integer.parseInt(command[2]);
                    if (startingIndex < 0 || startingIndex >= initialString.length() || endingIndex < 0 || endingIndex >= initialString.length() || startingIndex> endingIndex) {
                        System.out.println("Invalid indices!");
                    } else {
                        String subString = initialString.substring(startingIndex, endingIndex+1);
                        int sum = 0;
                        for (int i = 0; i < subString.length(); i++) {
                            sum += subString.charAt(i);
                        }
                        System.out.println(sum);
                    }
                    break;
            }

            command = scanner.nextLine().split("\\s+");
        }

    }
}
