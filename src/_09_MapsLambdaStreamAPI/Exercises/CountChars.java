package _09_MapsLambdaStreamAPI.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] charArray = scanner.nextLine().toCharArray();

        Map<Character, Integer> charsMap = new LinkedHashMap<>();
        for (char c : charArray) {
            if (!charsMap.containsKey(c) && c != ' ') {
                charsMap.put(c, 1);
            } else if (charsMap.containsKey(c)) {
                charsMap.put(c, charsMap.get(c) + 1);
            }
        }



        for (Map.Entry<Character, Integer> entry : charsMap.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
