package _11_FinalExam._01_FirstPracticeExam;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<Integer, Integer>> citiesMap = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while(!command.equals("Sail")) {
            String cityName = command.split("\\|\\|")[0];
            int population = Integer.parseInt(command.split("\\|\\|")[1]);
            int gold = Integer.parseInt(command.split("\\|\\|")[2]);

            if (!citiesMap.containsKey(cityName)) {
                Map<Integer, Integer> cityInformation = new LinkedHashMap<>();
                cityInformation.put(population, gold);
                citiesMap.put(cityName, cityInformation);
            } else {
                int oldPopulation = 0;
                int oldGold = 0;
                for (Map.Entry<String, Map<Integer, Integer>> stringMapEntry : citiesMap.entrySet()) {
                    if (stringMapEntry.getKey().equals(cityName)) {
                        for (Map.Entry<Integer, Integer> entry : stringMapEntry.getValue().entrySet()) {
                            oldPopulation = entry.getKey();
                            oldGold = entry.getValue();
                        }

                    }
                }
                population += oldPopulation;
                gold += oldGold;

                citiesMap.get(cityName).remove(oldPopulation);
                citiesMap.get(cityName).put(population, gold);
            }

            command = scanner.nextLine();
        }


        String events = scanner.nextLine();
        while(!events.equals("End")) {
            String[] tokens = events.split("=>");
            switch (tokens[0]) {
                case "Plunder":
                    int people = Integer.parseInt(tokens[2]);
                    int gold = Integer.parseInt(tokens[3]);
                    executePlunder(citiesMap,tokens[1], people, gold);
                    break;
                case "Prosper":
                    int goldAdded = Integer.parseInt(tokens[2]);
                    if (goldAdded<0){
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        executeProsper(citiesMap, tokens[1], goldAdded);
                    }
                    break;
            }
            events = scanner.nextLine();
        }

        if (citiesMap.size()==0) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", citiesMap.size());
            citiesMap.entrySet().stream()
                    .sorted((left, right) -> {
                        int rightGold = 0;
                        for (Map.Entry<Integer, Integer> entry : right.getValue().entrySet()) {
                            rightGold = entry.getValue();
                        }

                        int leftGold = 0;
                        for (Map.Entry<Integer, Integer> entry : left.getValue().entrySet()) {
                            leftGold = entry.getValue();
                        }

                        int result = 0;
                        if (rightGold>leftGold) {
                            result = 1;
                        } else if (rightGold < leftGold) {
                            result = -1;
                        }

                        if (result == 0) {
                            result = left.getKey().compareTo(right.getKey());
                        }

                        return result;
                    })
                    .forEach(e -> {
                        int gold = 0;
                        int population = 0;
                        for (Map.Entry<Integer, Integer> entry: e.getValue().entrySet()) {
                            gold = entry.getValue();
                            population = entry.getKey();
                        }

                        System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", e.getKey(), population, gold);
                    });
        }

    }

    private static void executeProsper(Map<String, Map<Integer, Integer>> citiesMap, String town, int goldAdded) {
        int population = 0;
        int oldGold = 0;
        for (Map.Entry<String, Map<Integer, Integer>> stringMapEntry : citiesMap.entrySet()) {
            if (stringMapEntry.getKey().equals(town)) {
                for (Map.Entry<Integer, Integer> entry : stringMapEntry.getValue().entrySet()) {
                    oldGold = entry.getValue();
                    population = entry.getKey();
                }
            }
        }

        int updatedGold = oldGold + goldAdded;
        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", goldAdded, town, updatedGold);

        citiesMap.get(town).put(population, updatedGold);

    }

    private static void executePlunder(Map<String, Map<Integer, Integer>> citiesMap, String town, int peopleKilled, int goldStolen) {
        int oldPopulation = 0;
        int oldGold = 0;
        for (Map.Entry<String, Map<Integer, Integer>> stringMapEntry : citiesMap.entrySet()) {
            if (stringMapEntry.getKey().equals(town)) {
                for (Map.Entry<Integer, Integer> entry : stringMapEntry.getValue().entrySet()) {
                    oldPopulation = entry.getKey();
                    oldGold = entry.getValue();
                }
            }
        }

        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, goldStolen, peopleKilled);

        int updatedPopulation = oldPopulation-peopleKilled;
        int updatedGold = oldGold - goldStolen;

        if (updatedPopulation<=0 || updatedGold <= 0) {
            citiesMap.remove(town);
            System.out.printf("%s has been wiped off the map!%n", town);
        } else {
            citiesMap.get(town).remove(oldPopulation);
            citiesMap.get(town).put(updatedPopulation, updatedGold);
        }
    }
}
