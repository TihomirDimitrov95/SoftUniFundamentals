package _08_Practice_Mid_Exam._06_SixthPracticeExam;

import java.util.Scanner;

public class _01_ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sumWithoutTax = 0;

        String command = scanner.nextLine();
        while(!command.equals("special") && !command.equals("regular")) {
            double currentPrice = Double.parseDouble(command);
            if (currentPrice<0) {
                System.out.println("Invalid price!");
                command = scanner.nextLine();
                continue;
            }
            sumWithoutTax += currentPrice;
            command = scanner.nextLine();
        }

        if (sumWithoutTax==0) {
            System.out.println("Invalid order!");
        } else {
            double taxes = sumWithoutTax*0.2;
            double finalSum = sumWithoutTax+taxes;
            if (command.equals("special")) {
                finalSum *= 0.9;
            }

            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", sumWithoutTax);
            System.out.printf("Taxes: %.2f$%n-----------%nTotal price: %.2f$", taxes, finalSum);
        }
    }
}
