package _04_Methods.Lab;

import java.util.Scanner;

public class Orders {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        double costOfOrder = GetCostOfOrder(product, quantity);
        System.out.printf("%.2f", costOfOrder);

    }

    private static double GetCostOfOrder(String product, int quantity) {
        double sum = 0;
        switch (product) {
            case "coffee" -> sum = quantity * 1.5;
            case "water" -> sum = quantity;
            case "coke" -> sum = quantity * 1.4;
            case "snacks" -> sum = quantity * 2;
            default -> System.out.println("Invalid input");
        }
        return sum;
    }
}
