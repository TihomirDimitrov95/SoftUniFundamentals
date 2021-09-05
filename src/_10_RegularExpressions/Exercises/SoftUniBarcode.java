package _10_RegularExpressions.Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarcode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "%(?<customer>[A-Z][a-z]+)%([^|$%.]*)<(?<product>\\w+)>([^|$%.]*)\\|(?<count>\\d+)\\|([^|$%.0-9]*)(?<price>\\d+[.]?[0-9]*)\\$";
        Pattern pattern = Pattern.compile(regex);

        double totalIncome = 0;
        String input = scanner.nextLine();
        while(!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String customer = matcher.group("customer");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));

                double totalPrice = count*price;

                System.out.printf("%s: %s - %.2f%n", customer, product, totalPrice);

                totalIncome += totalPrice;
            }

            input = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f", totalIncome);

    }
}
