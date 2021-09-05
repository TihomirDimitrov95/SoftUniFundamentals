package _11_FinalExam._02_SecondPracticeExam;

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String originalPassword = scanner.nextLine();

        String[] command = scanner.nextLine().split("\\s+");
        while(!command[0].equals("Done")) {
            switch(command[0]) {
                case "TakeOdd":
                    originalPassword = takeOddCharacters(originalPassword);
                    System.out.println(originalPassword);
                    break;
                case "Cut":
                    int index = Integer.parseInt(command[1]);
                    int length = Integer.parseInt(command[2]);
                    originalPassword = executeCut(originalPassword, index, length);
                    System.out.println(originalPassword);
                    break;
                case "Substitute":
                    String firstSubstring = command[1];
                    String secondSubstring = command[2];
                    if (originalPassword.contains(firstSubstring)) {
                        originalPassword = originalPassword.replaceAll(firstSubstring, secondSubstring);
                        System.out.println(originalPassword);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }

            command = scanner.nextLine().split("\\s+");
        }

        System.out.printf("Your password is: %s", originalPassword);

    }

    private static String executeCut(String originalPassword, int index, int length) {
        String substring = originalPassword.substring(index, index + length);

        originalPassword = originalPassword.replaceFirst(substring, "");

        return originalPassword;
    }

    private static String takeOddCharacters(String originalPassword) {
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < originalPassword.length(); i+=2) {
            char currentChar = originalPassword.charAt(i);
            result.append(currentChar);
        }

        return result.toString();
    }
}
