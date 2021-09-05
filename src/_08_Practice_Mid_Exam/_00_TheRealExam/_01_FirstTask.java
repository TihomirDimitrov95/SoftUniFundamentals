package _08_Practice_Mid_Exam._00_TheRealExam;

import java.util.Scanner;

public class _01_FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfOrders = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;

        for (int i = 0; i < numOfOrders; i++) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsulesCount = Integer.parseInt(scanner.nextLine());

            double price = (days*capsulesCount)*pricePerCapsule;
            System.out.printf("The price for the coffee is: $%.2f%n", price);
            totalPrice += price;
        }

        System.out.printf("Total: $%.2f", totalPrice);
    }
}
