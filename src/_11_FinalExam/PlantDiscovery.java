package _11_FinalExam;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numOfLines = Integer.parseInt(scanner.nextLine());

        Map<String, Map<Integer, List<Integer>>> plantsMap = new LinkedHashMap<>();
        for (int i = 0; i < numOfLines; i++) {
            String[] input = scanner.nextLine().split("<->");
            String plantName = input[0];
            int rarity = Integer.parseInt(input[1]);

            Map<Integer, List<Integer>> plantInfo = new LinkedHashMap<>();
            plantInfo.put(rarity, new ArrayList<>());

            plantsMap.put(plantName, plantInfo);
;
        }

        String command = scanner.nextLine();
        while(!command.equals("Exhibition")) {
            String[] tokens = command.split(": | \\- ");

            String typeOfCommand = tokens[0];
            String plantName = tokens[1];

            if (!plantsMap.containsKey(plantName)) {
                System.out.println("error");
                command = scanner.nextLine();
                continue;
            }

            switch (typeOfCommand) {
                case "Rate":
                    if (tokens.length!=3) {
                        System.out.println("error");
                    } else {
                        int rating = Integer.parseInt(tokens[2]);

                        int rarity = 0;
                        for (Map.Entry<Integer, List<Integer>> entry : plantsMap.get(plantName).entrySet()) {
                            rarity = entry.getKey();
                        }
                        plantsMap.get(plantName).get(rarity).add(rating);
                    }
                    break;
                case "Update":
                    if (tokens.length!=3) {
                        System.out.println("error");
                    } else {
                        int newRarity = Integer.parseInt(tokens[2]);

                        List<Integer> oldRatings = new ArrayList<>();
                        int oldRarity = 0;
                        for (Map.Entry<Integer, List<Integer>> entry : plantsMap.get(plantName).entrySet()) {
                            oldRatings = entry.getValue();
                            oldRarity = entry.getKey();
                        }

                        plantsMap.get(plantName).put(newRarity, oldRatings);
                        plantsMap.get(plantName).remove(oldRarity);
                    }

                    break;
                case "Reset":
                    if (tokens.length!=2) {
                        System.out.println("error");
                    } else {
                        int rarityReset = 0;
                        for (Map.Entry<Integer, List<Integer>> entry : plantsMap.get(plantName).entrySet()) {
                            rarityReset = entry.getKey();
                        }

                        plantsMap.get(plantName).remove(rarityReset);

                        plantsMap.get(plantName).put(rarityReset, new ArrayList<>());
                    }
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            command = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        plantsMap.entrySet().stream()
                .sorted((left, right) -> {
                    int leftRarity = 0;
                    for (Map.Entry<Integer, List<Integer>> entryLeft : left.getValue().entrySet()) {
                        leftRarity = entryLeft.getKey();
                    }

                    int rightRarity = 0;
                    for (Map.Entry<Integer, List<Integer>> entryRight : right.getValue().entrySet()) {
                        rightRarity = entryRight.getKey();
                    }

                    int result = 0;
                    if (rightRarity>leftRarity) {
                        result = 1;
                    } else if (rightRarity < leftRarity) {
                        result = -1;
                    }

                    if (result == 0) {
                        double leftAverageRating = 0;
                        for(int ratingLeft : left.getValue().get(leftRarity)) {
                            leftAverageRating += ratingLeft;
                        }
                        if (leftAverageRating>0) {
                            leftAverageRating /= left.getValue().get(leftRarity).size();
                        }

                        double rightAverageRating = 0;
                        for(int ratingRight : right.getValue().get(rightRarity)) {
                            rightAverageRating += ratingRight;
                        }
                        if (rightAverageRating>0) {
                            rightAverageRating /= right.getValue().get(rightRarity).size();
                        }

                        if (rightAverageRating > leftAverageRating) {
                            result = 1;
                        } else if (rightAverageRating < leftAverageRating) {
                            result = -1;
                        }
                    }

                    return result;
                })
                .forEach(e -> {
                    int rarity = 0;
                    for (Map.Entry<Integer, List<Integer>> entry : e.getValue().entrySet()) {
                        rarity = entry.getKey();
                    }

                    double averageRating = 0;
                    for (int rating : e.getValue().get(rarity)) {
                        averageRating += rating;
                    }
                    if (averageRating > 0) {
                        averageRating /= e.getValue().get(rarity).size();
                    }

                    System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", e.getKey(), rarity, averageRating);
                });

    }
}
