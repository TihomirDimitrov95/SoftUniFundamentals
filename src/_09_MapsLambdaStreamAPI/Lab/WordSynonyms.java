package _09_MapsLambdaStreamAPI.Lab;

import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> wordSynonymsMap = new LinkedHashMap<>();

        int numberOfInputs = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfInputs; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            if (!wordSynonymsMap.containsKey(word)) {
                List<String> synonyms = new ArrayList<>();
                synonyms.add(synonym);
                wordSynonymsMap.put(word, synonyms);
            } else {
                if (!wordSynonymsMap.get(word).contains(synonym)) {
                    wordSynonymsMap.get(word).add(synonym);
                }
            }
        }

        for (Map.Entry<String, List<String>> entry : wordSynonymsMap.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), entry.getValue().
                    toString().
                    replaceAll("[\\[\\]]", ""));
        }

    }
}
