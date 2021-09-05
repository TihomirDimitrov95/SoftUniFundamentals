package _09_MapsLambdaStreamAPI.Exercises;

import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new HashMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        Map<String, Integer> otherMaterials = new HashMap<>();

        while(targetNotReached(keyMaterials)) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int i = 1; i < input.length; i+=2) {
                String material = input[i].toLowerCase();
                int quantity = Integer.parseInt(input[i-1]);
                if (keyMaterials.containsKey(material)) {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);
                } else {
                    if (otherMaterials.containsKey(material)) {
                        otherMaterials.put(material, otherMaterials.get(material) + quantity);
                    } else {
                        otherMaterials.put(material, quantity);
                    }
                }

                if (!targetNotReached(keyMaterials)) {
                    break;
                }
            }
        }

        printLegendaryItem(keyMaterials);

        keyMaterials.entrySet()
                .stream()
                .sorted((left, right) -> {
                    int result = right.getValue().compareTo(left.getValue());
                    if (result == 0) {
                        result = left.getKey().compareTo(right.getKey());
                    }
                    return result;
                })
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

        otherMaterials.entrySet()
                .stream()
                .sorted((left, right) -> left.getKey().compareTo(right.getKey()))
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

    }

    private static void printLegendaryItem(Map<String, Integer> keyMaterials) {
        if (keyMaterials.get("shards")>=250) {
            System.out.println("Shadowmourne obtained!");
            keyMaterials.put("shards", keyMaterials.get("shards")-250);
        } else if (keyMaterials.get("fragments")>=250) {
            System.out.println("Valanyr obtained!");
            keyMaterials.put("fragments", keyMaterials.get("fragments")-250);
        } else if (keyMaterials.get("motes")>=250) {
            System.out.println("Dragonwrath obtained!");
            keyMaterials.put("motes", keyMaterials.get("motes")-250);
        }
    }

    private static boolean targetNotReached(Map<String, Integer> keyMaterials) {
        boolean result = true;
        if (keyMaterials.get("shards")>=250) {
            result = false;
        } else if (keyMaterials.get("fragments") >= 250) {
            result = false;
        } else if (keyMaterials.get("motes")>=250) {
            result = false;
        }

        return result;
    }
}
