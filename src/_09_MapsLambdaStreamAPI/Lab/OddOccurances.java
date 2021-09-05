package _09_MapsLambdaStreamAPI.Lab;

import java.util.*;
import java.util.stream.Stream;

public class OddOccurances {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        Map<String, Integer> elementsOccurencesMap = new LinkedHashMap<>();

        for (String elements : input) {
            if (!elementsOccurencesMap.containsKey(elements.toLowerCase())) {
                elementsOccurencesMap.put(elements.toLowerCase(), 1);
            } else {
                int value = elementsOccurencesMap.get(elements.toLowerCase());
                value++;
                elementsOccurencesMap.put(elements.toLowerCase(), value);
            }
        }

        StringBuilder output = new StringBuilder();

        for (Map.Entry<String, Integer> entry : elementsOccurencesMap.entrySet()) {
            if (entry.getValue()%2==1) {
                output.append(entry.getKey()).append(", ");
            }
        }

        System.out.println(output.substring(0, output.length()-2));

    }
}
