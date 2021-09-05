package _09_MapsLambdaStreamAPI.MoreExercises;

import java.io.PrintStream;
import java.util.*;
import java.util.stream.Stream;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Integer> usersMap = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> contestsMap = new LinkedHashMap<>();

        String[] input = scanner.nextLine().split(" -> ");
        while (!input[0].equals("no more time")) {
            String username = input[0];
            String contest = input[1];
            int points = Integer.parseInt(input[2]);

            contestsMap.putIfAbsent(contest, new LinkedHashMap<>());
            if (!contestsMap.get(contest).containsKey(username)) {
                contestsMap.get(contest).put(username, points);
            } else {
                if (contestsMap.get(contest).get(username) < points) {
                    contestsMap.get(contest).put(username, points);
                }
            }

            input = scanner.nextLine().split(" -> ");
        }

        for (Map.Entry<String, Map<String, Integer>> entry : contestsMap.entrySet()) {
            for (Map.Entry<String, Integer> contestEntries : entry.getValue().entrySet()) {
                if (!usersMap.containsKey(contestEntries.getKey())) {
                    usersMap.put(contestEntries.getKey(), contestEntries.getValue());
                } else {
                    int updatedPoints = usersMap.get(contestEntries.getKey()) + contestEntries.getValue();
                    usersMap.put(contestEntries.getKey(), updatedPoints);
                }
            }
        }


        for (Map.Entry<String, Map<String, Integer>> entry : contestsMap.entrySet()) {
            System.out.printf("%s: %d participants%n", entry.getKey(), entry.getValue().size());

            int[] iarr = {0};
            entry.getValue().entrySet().stream()
                    .sorted((left, right) -> {
                        int result = 0;
                        if (right.getValue() > left.getValue()) {
                            result = 1;
                        } else if (right.getValue() < left.getValue()) {
                            result = -1;
                        }

                        if (result == 0) {
                            left.getKey().compareTo(right.getKey());
                        }

                        return result;
                    }).forEach(e -> {
                iarr[0]++;
                System.out.printf("%d. %s <::> %d%n", iarr[0], e.getKey(), e.getValue());
            });


        }

        if (usersMap.size() > 0) {
            System.out.println("Individual standings:");

            int[] iarrTwo = {0};
            usersMap.entrySet().stream()
                    .sorted((left, right) -> {
                        int result = 0;
                        if (right.getValue() > left.getValue()) {
                            result = 1;
                        } else if (right.getValue() < left.getValue()) {
                            result = -1;
                        }

                        if (result == 0) {
                            result = left.getKey().compareTo(right.getKey());
                        }

                        return result;
                    })
                    .forEach(e -> {
                        iarrTwo[0]++;
                        System.out.printf("%d. %s -> %d%n", iarrTwo[0], e.getKey(), e.getValue());
                    });
        }


    }
}
