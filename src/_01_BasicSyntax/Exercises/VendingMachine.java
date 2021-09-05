package _01_BasicSyntax.Exercises;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double sum  = 0;
        boolean flag = false;

        while (!input.equals("Start")) {
            double num = Double.parseDouble(input);
            if (num!=0.1 && num!=0.2 && num!= 0.5 && num!=1 && num!=2) {
                System.out.printf("Cannot accept %.2f%n", num);
            } else {
                sum+=num;
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("End")) {
            switch (input) {
                case "Nuts":
                    sum -= 2;
                    break;
                case "Water":
                    sum -= 0.7;
                    break;
                case "Crisps":
                    sum -= 1.5;
                    break;
                case "Soda":
                    sum -= 0.8;
                    break;
                case "Coke":
                    sum -= 1;
                    break;
                default:
                    System.out.println("Invalid product");
                    flag = true;
                    break;
            }
            if (flag) {
                input = scanner.nextLine();
                flag = false;
                continue;
            }
            if (sum>=0) {
                System.out.printf("Purchased %s%n", input);
            } else {
                System.out.println("Sorry, not enough money");
                switch (input) {
                    case "Nuts":
                        sum += 2;
                        break;
                    case "Water":
                        sum += 0.7;
                        break;
                    case "Crisps":
                        sum += 1.5;
                        break;
                    case "Soda":
                        sum += 0.8;
                        break;
                    case "Coke":
                        sum += 1;
                        break;
                }
            }
            input = scanner.nextLine();
        }
        if (sum>=0) {
            System.out.printf("Change: %.2f", sum);
        }
    }
}
