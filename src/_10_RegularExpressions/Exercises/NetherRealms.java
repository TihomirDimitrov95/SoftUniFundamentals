package _10_RegularExpressions.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] demonNames = scanner.nextLine().split("\\s*,\\s*");

        Map<String, Map<Integer, Double>> demonsMap = new TreeMap<>();

        for (String demon : demonNames) {
            int demonHealth = getHealthOfDemon(demon);
            double damage = getDamageOfDemon(demon);

            Map<Integer, Double> demonDetails = new LinkedHashMap<>();
            demonDetails.put(demonHealth, damage);

            demonsMap.put(demon, demonDetails);
        }

        demonsMap.entrySet().stream()
                .sorted((left, right) -> left.getKey().compareTo(right.getKey()))
                .forEach(e -> {
                    int health = 0;
                    double damage = 0;

                    for (Map.Entry<Integer, Double> demonDetails : e.getValue().entrySet()) {
                        health = demonDetails.getKey();
                        damage = demonDetails.getValue();
                    }

                    System.out.printf("%s - %d health, %.2f damage%n", e.getKey(), health, damage);
                });

    }

    private static double getDamageOfDemon(String demon) {
        double damage = 0;

        String regexForFloatingNumbers = "[-]?[0-9]+[.]?[0-9]*";
        Pattern patternForFloatingNumbers = Pattern.compile(regexForFloatingNumbers);

        Matcher matcher = patternForFloatingNumbers.matcher(demon);
        while (matcher.find()) {
            double number = Double.parseDouble(matcher.group());

            damage += number;
        }

        String regexForOperations = "[*/]";
        Pattern patternForOperations = Pattern.compile(regexForOperations);

        Matcher matcher1 = patternForOperations.matcher(demon);
        while (matcher1.find()) {
            char symbol = matcher1.group().charAt(0);

            if (symbol == '*') {
                damage *= 2;
            } else if (symbol == '/') {
                damage /= 2;
            }
        }

        return damage;
    }

    private static int getHealthOfDemon(String demon) {
        int health = 0;

        String regex = "[^0-9.+*/\\-]";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(demon);
        while (matcher.find()) {
            char current = matcher.group().charAt(0);

            health += current;
        }


        return health;
    }
}
