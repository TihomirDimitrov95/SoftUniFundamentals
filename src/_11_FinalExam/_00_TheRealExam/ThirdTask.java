package _11_FinalExam._00_TheRealExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> animalsMap = new LinkedHashMap<>();

        String[] command = scanner.nextLine().split(": |-");
        while(!command[0].equals("EndDay")) {
            String typeOfCommand = command[0];
            String animalName = command[1];

            switch (typeOfCommand) {
                case "Add":
                    int foodRequired = Integer.parseInt(command[2]);
                    String area = command[3];
                    Map<String, Integer> animalInfo = new LinkedHashMap<>();

                    if (!animalsMap.containsKey(animalName)) {
                        animalInfo.put(area, foodRequired);
                    } else {
                        int oldFoodRequired = 0;
                        for (Map.Entry<String, Integer> entry : animalsMap.get(animalName).entrySet()) {
                            oldFoodRequired = entry.getValue();
                        }
                        int updatedFoodRequired = oldFoodRequired + foodRequired;

                        animalInfo.put(area, updatedFoodRequired);
                    }
                    animalsMap.put(animalName, animalInfo);
                    break;
                case "Feed":
                    int foodToFeed = Integer.parseInt(command[2]);

                    if (animalsMap.containsKey(animalName)) {
                        int oldFood = 0;
                        String animalArea = "";
                        for (Map.Entry<String, Integer> entry : animalsMap.get(animalName).entrySet()) {
                            oldFood = entry.getValue();
                            animalArea = entry.getKey();
                        }
                        int newFoodRequired = oldFood-foodToFeed;

                        if (newFoodRequired<=0) {
                            System.out.printf("%s was successfully fed%n", animalName);
                            animalsMap.remove(animalName);
                        } else {
                            Map<String, Integer> updatedAnimalInfo = new LinkedHashMap<>();
                            updatedAnimalInfo.put(animalArea, newFoodRequired);
                            animalsMap.put(animalName, updatedAnimalInfo);
                        }
                    }
                    break;
            }
            command = scanner.nextLine().split(": |-");
        }

        if (animalsMap.size()>0) {
            System.out.println("Animals:");
            animalsMap.entrySet().stream()
                    .sorted((left, right) -> {
                        int result = 0;

                        int foodLeft = 0;
                        for (Map.Entry<String, Integer> entry : left.getValue().entrySet()) {
                            foodLeft = entry.getValue();
                        }

                        int foodRight = 0;
                        for (Map.Entry<String, Integer> entry : right.getValue().entrySet()) {
                            foodRight = entry.getValue();
                        }

                        if (foodRight>foodLeft) {
                            result = 1;
                        } else if (foodRight<foodLeft) {
                            result = -1;
                        }

                        if (result ==0) {
                            result = left.getKey().compareTo(right.getKey());
                        }
                        return result;
                    })
                    .forEach(e -> {
                        int food = 0;
                        for (Map.Entry<String, Integer> entry : e.getValue().entrySet()) {
                            food = entry.getValue();
                        }

                        System.out.printf(" %s -> %dg%n", e.getKey(), food);
                    });

            Map<String, Integer> areasMap = new LinkedHashMap<>();
            for (Map.Entry<String, Map<String, Integer>> stringMapEntry : animalsMap.entrySet()) {
                String hungryArea = "";
                for (Map.Entry<String, Integer> entry : stringMapEntry.getValue().entrySet()) {
                    hungryArea = entry.getKey();
                }

                if (!areasMap.containsKey(hungryArea)) {
                    areasMap.put(hungryArea, 1);
                } else {
                    int hungryAnimals = areasMap.get(hungryArea) + 1;
                    areasMap.put(hungryArea, hungryAnimals);
                }
            }

            System.out.println("Areas with hungry animals:");
            areasMap.entrySet().stream()
                    .sorted((left, right) -> {
                        int result = right.getValue().compareTo(left.getValue());

                        if (result == 0 ) {
                            result = left.getKey().compareTo(right.getKey());
                        }

                        return result;
                    })
                    .forEach(e -> {
                        System.out.printf(" %s: %d%n", e.getKey(), e.getValue());
                    });
        }

    }
}