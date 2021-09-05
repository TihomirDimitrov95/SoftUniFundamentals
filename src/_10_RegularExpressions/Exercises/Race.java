package _10_RegularExpressions.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> participants = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        Map<String, Integer> participantsMap = new LinkedHashMap<>();
        for (String participant : participants) {
            participantsMap.put(participant, 0);
        }

        String regexForName = "[A-Za-z]";
        Pattern namePattern = Pattern.compile(regexForName);

        String regexForDistance = "[0-9]";
        Pattern distancePattern = Pattern.compile(regexForDistance);

        String input = scanner.nextLine();
        while (!input.equals("end of race")){
            Matcher matcherForNames = namePattern.matcher(input);
            Matcher matcherForDistance = distancePattern.matcher(input);

            StringBuilder name = new StringBuilder();
            while(matcherForNames.find()) {
                name.append(matcherForNames.group());
            }

            if (participants.contains(name.toString())) {
                int previousDistance = participantsMap.get(name.toString());

                int currentDistance = 0;
                while(matcherForDistance.find()) {
                    currentDistance += Integer.parseInt(matcherForDistance.group());
                }

                participantsMap.put(name.toString(), previousDistance+currentDistance);
            }

            input = scanner.nextLine();
        }

        int[] counter = {1};
        participantsMap.entrySet().stream()
                .sorted((left, right) -> right.getValue().compareTo(left.getValue()))
                .limit(3)
                .forEach(e -> {
                    switch(counter[0]) {
                        case 1:
                            System.out.printf("1st place: %s%n", e.getKey());
                            break;
                        case 2:
                            System.out.printf("2nd place: %s%n", e.getKey());
                            break;
                        case 3:
                            System.out.printf("3rd place: %s%n", e.getKey());
                            break;
                    }
                    counter[0]++;
                });
    }
}
