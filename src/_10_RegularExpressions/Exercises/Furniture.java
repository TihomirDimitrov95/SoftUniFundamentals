package _10_RegularExpressions.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = ">{2}(?<name>\\w+)<{2}(?<price>\\d+\\.?\\d+)!(?<quantity>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        List<String> boughtFurniture = new ArrayList<>();
        double totalPrice = 0;

        String text = scanner.nextLine();
        while (!text.equals("Purchase")) {
            Matcher matcher = pattern.matcher(text);

            while(matcher.find()) {
                String furnitureName = matcher.group("name");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                boughtFurniture.add(furnitureName);
                totalPrice += price*quantity;
            }

            text = scanner.nextLine();
        }

        if (boughtFurniture.size()>0) {
            System.out.println("Bought furniture:");
            for (String furniture : boughtFurniture) {
                System.out.println(furniture);
            }

            System.out.printf("Total money spend: %.2f", totalPrice);
        }

    }
}
