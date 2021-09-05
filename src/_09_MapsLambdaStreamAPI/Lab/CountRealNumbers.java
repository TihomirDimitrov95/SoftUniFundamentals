package _09_MapsLambdaStreamAPI.Lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Double, Integer> realNumbers = new TreeMap<>();

        double[] nums = Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToDouble(Double::parseDouble)
                .toArray();

        for (double num : nums) {
            if (!realNumbers.containsKey(num)) {
                realNumbers.put(num, 1);
            } else {
                int value = realNumbers.get(num);
                value++;
                realNumbers.put(num, value);
            }
        }

        DecimalFormat dc = new DecimalFormat("#.#######");
        for (Map.Entry<Double, Integer> entry : realNumbers.entrySet()) {
            System.out.printf("%s -> %d%n", dc.format(entry.getKey()), entry.getValue());
        }

    }
}
