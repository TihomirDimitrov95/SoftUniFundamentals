package _01_BasicSyntax.Exercises;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groupSize = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String dayOfVisit = scanner.nextLine();
        double finalPrice = 0;

        switch (groupType) {
            case "Students":
                switch (dayOfVisit) {
                    case "Friday":
                        finalPrice = groupSize*8.45;
                        break;
                    case "Saturday":
                        finalPrice = groupSize*9.8;
                        break;
                    case "Sunday":
                        finalPrice = groupSize*10.46;
                        break;
                }
                if (groupSize>=30) {
                    finalPrice = finalPrice*0.85;
                }
                break;
            case "Business":
                switch (dayOfVisit) {
                    case "Friday":
                        finalPrice = groupSize*10.90;
                        break;
                    case "Saturday":
                        finalPrice = groupSize*15.6;
                        break;
                    case "Sunday":
                        finalPrice = groupSize*16;
                        break;
                }
                if (groupSize>=100) {
                    finalPrice -= (finalPrice/groupSize)*10;
                }
                break;
            case "Regular":
                switch (dayOfVisit) {
                    case "Friday":
                        finalPrice = groupSize*15;
                        break;
                    case "Saturday":
                        finalPrice = groupSize*20;
                        break;
                    case "Sunday":
                        finalPrice = groupSize*22.5;
                        break;
                }
                if (groupSize>=10 && groupSize <= 20) {
                    finalPrice = finalPrice*0.95;
                }
                break;
        }

        System.out.printf("Total price: %.2f", finalPrice);

    }
}
