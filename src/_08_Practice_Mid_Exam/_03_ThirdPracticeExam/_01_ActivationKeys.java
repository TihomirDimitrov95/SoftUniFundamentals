package _08_Practice_Mid_Exam._03_ThirdPracticeExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String activationKey = scanner.nextLine();
        List<String> keyAsList = Arrays.stream(activationKey.split("")).collect(Collectors.toList());

        String[] tokens = scanner.nextLine().split(">>>");
        while (!tokens[0].equals("Generate")) {
            String typeOfCommand = tokens[0];

            switch(typeOfCommand.toLowerCase()) {
                case "contains":
                    if (activationKey.contains(tokens[1])) {
                        System.out.printf("%s contains %s%n", activationKey, tokens[1]);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "flip":
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);
                    switch (tokens[1].toLowerCase()) {
                        case "upper":
                            for (int i = startIndex; i < endIndex; i++) {
                                String upper = keyAsList.get(i).toUpperCase();
                                keyAsList.set(i, upper);
                            }
                            break;
                        case "lower":
                            for (int i = startIndex; i < endIndex; i++) {
                                String lower = keyAsList.get(i).toLowerCase();
                                keyAsList.set(i, lower);
                            }
                            break;
                    }
                    System.out.println(String.join("", keyAsList));
                    break;
                case "slice":
                    int start = Integer.parseInt(tokens[1]);
                    int end = Integer.parseInt(tokens[2]);
                    int count = end-start;
                    for (int i = 0; i < count; i++) {
                        keyAsList.remove(start);
                    }
                    System.out.println(String.join("", keyAsList));
                    break;
            }

            tokens = scanner.nextLine().split(">>>");
            activationKey = String.join("", keyAsList);
        }

        System.out.printf("Your activation key is: %s", String.join("", keyAsList));
    }
}
