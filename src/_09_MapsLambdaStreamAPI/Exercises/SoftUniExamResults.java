package _09_MapsLambdaStreamAPI.Exercises;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> usersMap = new LinkedHashMap<>();
        Map<String, Integer> languagesMap = new LinkedHashMap<>();

        String[] input = scanner.nextLine().split("-");
        while(!input[0].equals("exam finished")) {
            String username = input[0];
            String language = input[1];

            int points = 0;
            if (input.length==3) {
                points = Integer.parseInt(input[2]);
                if (!usersMap.containsKey(username)) {
                    usersMap.put(username, points);
                } else {
                    if (points>usersMap.get(username)) {
                        usersMap.put(username, points);
                    }
                }
                if (!languagesMap.containsKey(language)) {
                    languagesMap.put(language, 1);
                } else {
                    int submissions = languagesMap.get(language) + 1;
                    languagesMap.put(language, submissions);
                }

            } else {
                usersMap.remove(username);
            }


            input = scanner.nextLine().split("-");
        }


        System.out.println("Results:");
        usersMap.entrySet().stream()
                .sorted((left, right) -> {
                    int result = right.getValue().compareTo(left.getValue());

                    if (result == 0) {
                        result = left.getKey().compareTo(right.getKey());
                    }

                    return result;
                })
                .forEach(e -> System.out.printf("%s | %d%n", e.getKey(), e.getValue()));

        System.out.println("Submissions:");
        languagesMap.entrySet().stream()
                .sorted((left, right) -> {
                    int result = right.getValue().compareTo(left.getValue());

                    if (result == 0) {
                        result = left.getKey().compareTo(right.getKey());
                    }

                    return result;
                })
                .forEach(e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue()));
    }
}
