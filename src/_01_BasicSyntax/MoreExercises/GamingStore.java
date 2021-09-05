package _01_BasicSyntax.MoreExercises;

import java.util.Scanner;

public class GamingStore {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = Double.parseDouble(sc.nextLine());
        double spendTracker = balance;

        String gameBought = sc.nextLine();
        while (!gameBought.equals("Game Time")) {
            switch (gameBought) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    if (balance<39.99) {
                        System.out.println("Too Expensive");
                    } else {
                        balance -= 39.99;
                        System.out.printf("Bought %s%n", gameBought);
                    }
                    break;
                case "CS:OG":
                    if (balance<15.99) {
                        System.out.println("Too Expensive");
                    } else {
                        balance -= 15.99;
                        System.out.printf("Bought %s%n", gameBought);
                    }
                    break;
                case "Zplinter Zell":
                    if (balance<19.99) {
                        System.out.println("Too Expensive");
                    } else {
                        balance -= 19.99;
                        System.out.printf("Bought %s%n", gameBought);
                    }
                    break;
                case "Honored 2":
                    if (balance<59.99) {
                        System.out.println("Too Expensive");
                    } else {
                        balance -= 59.99;
                        System.out.printf("Bought %s%n", gameBought);
                    }
                    break;
                case "RoverWatch":
                    if (balance<29.99) {
                        System.out.println("Too Expensive");
                    } else {
                        balance -= 29.99;
                        System.out.printf("Bought %s%n", gameBought);
                    }
                    break;
                default:
                    System.out.println("Not Found");
                    break;
            }
            if (balance==0) {
                System.out.println("Out of money!");
            }
            gameBought = sc.nextLine();
        }
        if (balance!=0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spendTracker-balance, balance);
        }
    }
}
