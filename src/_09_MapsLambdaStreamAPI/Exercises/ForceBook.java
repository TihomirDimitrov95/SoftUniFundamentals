package _09_MapsLambdaStreamAPI.Exercises;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, List<String>> forceUsers = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Lumpawaroo")) {
            String commandType = "";
            if (input.contains(" | ")) {
                commandType = "|";
            } else if (input.contains(" -> ")){
                commandType = "->";
            }

            switch (commandType) {
                case "|":
                    String tokenOne = input.substring(0, input.indexOf('|')-1);
                    String tokenTwo = input.substring(input.indexOf('|')+2);
                    addUserIfAbsent(forceUsers, tokenOne, tokenTwo);
                    break;
                case "->":
                    String tokenThree = input.substring(0, input.indexOf('-')-1);
                    String tokenFour = input.substring(input.indexOf('>')+2);;
                    changeSideIfPresent(forceUsers, tokenThree, tokenFour);
                    break;
            }

            input = scanner.nextLine();
        }


        for (Map.Entry<String, List<String>> entry : forceUsers.entrySet()) {
            Collections.sort(entry.getValue());
        }

        forceUsers.entrySet().stream()
                .sorted((left, right) -> {
                    int result = 0;
                    if (right.getValue().size()>left.getValue().size()) {
                        result = 1;
                    } else if (right.getValue().size()<left.getValue().size()) {
                        result = -1;
                    };
                    return result;
                } )
                .forEach(e -> {
                    if (e.getValue().size()>0) {
                        System.out.printf("Side: %s, Members: %d%n", e.getKey(), e.getValue().size());
                        for (String user: e.getValue()) {
                            System.out.printf("! %s%n", user);
                        }
                    }
                });
    }

    private static void changeSideIfPresent(Map<String, List<String>> forceUsers, String forceUser, String forceSide) {
        boolean doesUserExist = false;
        int countOfSides = 0;
        for (Map.Entry<String, List<String>> entry : forceUsers.entrySet()) {
            countOfSides++;
            for (String user : entry.getValue()) {
                if (user.equals(forceUser)) {
                    doesUserExist = true;
                    entry.getValue().remove(user);
                    break;
                }
            }
        }

        forceUsers.putIfAbsent(forceSide, new ArrayList<>());

        forceUsers.get(forceSide).add(forceUser);
        System.out.printf("%s joins the %s side!%n", forceUser, forceSide);

    }

    private static void addUserIfAbsent(Map<String, List<String>> forceUsers, String forceSide, String forceUser) {
        forceUsers.putIfAbsent(forceSide, new ArrayList<>());

        if (!forceUsers.get(forceSide).contains(forceUser)) {
            forceUsers.get(forceSide).add(forceUser);
        }

    }
}
