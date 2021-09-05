package _02_DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startingYield = Integer.parseInt(scanner.nextLine());

        int totalAmountExtracted = 0;
        int numberOfActiveMineDays = 0;

        while (startingYield>=100) {
            totalAmountExtracted+=startingYield;
            startingYield -= 10;
            totalAmountExtracted -= 26;
            numberOfActiveMineDays++;
        }
        if (totalAmountExtracted>0) {
            totalAmountExtracted-=26;
        }

        System.out.println(numberOfActiveMineDays);
        System.out.println(totalAmountExtracted);


    }
}
