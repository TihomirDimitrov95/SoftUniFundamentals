package _09_MapsLambdaStreamAPI.MoreExercises;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contestsMap = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while(!input.equals("end of contests")){
            String contest = input.split(":")[0];
            String passwordForContest = input.split(":")[1];

            contestsMap.putIfAbsent(contest, passwordForContest);

            input = scanner.nextLine();
        }

        Map<String, Map<String, Integer>> usersMap = new LinkedHashMap<>();

        String[] usersInput = scanner.nextLine().split("=>");
        while(!usersInput[0].equals("end of submissions")) {
            String contest = usersInput[0];
            String password = usersInput[1];
            String username = usersInput[2];
            int points = Integer.parseInt(usersInput[3]);

            if (contestsMap.containsKey(contest) && contestsMap.get(contest).equals(password)) {
                Map<String, Integer> currentUser = new LinkedHashMap<>();
                currentUser.put(contest, points);

                if (!usersMap.containsKey(username)) {
                    usersMap.put(username, currentUser);
                } else {
                    if (usersMap.get(username).containsKey(contest) && usersMap.get(username).get(contest)<points) {
                        usersMap.get(username).put(contest, points);
                    } else if (!usersMap.get(username).containsKey(contest)) {
                        usersMap.get(username).put(contest, points);
                    }
                }
            }

            usersInput = scanner.nextLine().split("=>");
        }

        String bestCandidate = "";
        int highestPoints = 0;
        for (Map.Entry<String, Map<String, Integer>> entry : usersMap.entrySet()) {
            int totalPoints = 0;

            for (Map.Entry<String, Integer> contests : entry.getValue().entrySet()) {
                totalPoints += contests.getValue();
            }

            if (totalPoints>highestPoints) {
                highestPoints = totalPoints;
                bestCandidate = entry.getKey();
            }
        }

        System.out.printf("Best candidate is %s with total %d points.%n", bestCandidate, highestPoints);
        System.out.println("Ranking: ");
        usersMap.entrySet().stream()
                .sorted((left, right) -> left.getKey().compareTo(right.getKey()))
                .forEach(e -> {
                    System.out.println(e.getKey());

                    e.getValue().entrySet().stream()
                            .sorted((left, right) -> right.getValue().compareTo(left.getValue()))
                            .forEach(element -> {
                                System.out.printf("#  %s -> %d%n", element.getKey(), element.getValue());
                            });
                });

    }
}
