package _10_RegularExpressions.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> planetsMap = new TreeMap<>();
        planetsMap.put("A", new ArrayList<>());
        planetsMap.put("D", new ArrayList<>());

        String regexForKey = "[ARSTarst]";
        Pattern patternForKey = Pattern.compile(regexForKey);

        int numOfMessages = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfMessages; i++) {
            String encryptedMessage = scanner.nextLine();

            Matcher matcher = patternForKey.matcher(encryptedMessage);
            int key = 0;
            while (matcher.find()) {
                key++;
            }

            StringBuilder decryptedMessage = new StringBuilder();
            for (int j = 0; j < encryptedMessage.length(); j++) {
                char currentChar = (char) (encryptedMessage.charAt(j) - key);
                decryptedMessage.append(currentChar);
            }

            String regexForPlanet = "@(?<planet>[A-Za-z]+)[^\\-@!:>]*:(?<population>\\d+)[^\\-@!:>]*!(?<attackType>[AD])![^\\-@!:>]*\\->(?<soldierCount>\\d+)";
            Pattern patternForPlanet = Pattern.compile(regexForPlanet);

            Matcher planetMatcher = patternForPlanet.matcher(decryptedMessage.toString());
            if (planetMatcher.find()) {
                String planet = planetMatcher.group("planet");
                String attackType = planetMatcher.group("attackType");

                if (attackType.equals("A")) {
                    planetsMap.get("A").add(planet);
                } else if (attackType.equals("D")) {
                    planetsMap.get("D").add(planet);
                }
            }
        }


        planetsMap.entrySet().stream()
                .forEach(e -> {
                    switch (e.getKey()) {
                        case "A":
                            System.out.printf("Attacked planets: %d%n", e.getValue().size());
                            break;
                        case "D":
                            System.out.printf("Destroyed planets: %d%n", e.getValue().size());
                            break;
                    }

                    Collections.sort(e.getValue());
                    for (String planet : e.getValue()) {
                        System.out.printf("-> %s%n", planet);
                    }
                });

    }
}
