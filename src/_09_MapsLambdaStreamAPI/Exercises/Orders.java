package _09_MapsLambdaStreamAPI.Exercises;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<Double, Integer>> productsMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("buy")) {
            String name = input.split("\\s+")[0];
            double price = Double.parseDouble(input.split("\\s+")[1]);
            int quantity = Integer.parseInt(input.split("\\s+")[2]);

            Map<Double, Integer> value = new HashMap<>();
            value.put(price, quantity);

            if(!productsMap.containsKey(name)) {
                productsMap.put(name, value);
            } else {
                if(productsMap.get(name).containsKey(price)) {
                    int updatedQuantity = productsMap.get(name).get(price) + quantity;
                    productsMap.get(name).put(price, updatedQuantity);
                } else {
                    Map<Double, Integer> oldValues = productsMap.get(name);

                    int newQuantity = quantity;
                    double oldPrice = 0;
                    for (Map.Entry<Double, Integer> entry : oldValues.entrySet()) {
                        newQuantity += entry.getValue();
                        oldPrice += entry.getKey();
                    }

                    productsMap.get(name).remove(oldPrice);
                    productsMap.get(name).put(price, newQuantity);
                }
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<Double, Integer>> entry : productsMap.entrySet()) {
            Map<Double, Integer> current = entry.getValue();
            double totalPrice = 0;
            for (Map.Entry<Double, Integer> doubleIntegerEntry : current.entrySet()) {
                totalPrice += doubleIntegerEntry.getKey()*doubleIntegerEntry.getValue();
            }
            System.out.printf("%s -> %.2f%n", entry.getKey(), totalPrice);
        }
    }
}
