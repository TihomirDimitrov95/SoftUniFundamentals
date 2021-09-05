package _02_DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfSnowballs = Integer.parseInt(scanner.nextLine());

        int maxSnowballValue = 0;
        int maxSnow = 0;
        int maxTime = 0;
        int maxQuality = 0;

        for (int i = 0; i < numOfSnowballs; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            double snowballQuality = Double.parseDouble(scanner.nextLine());

            double interim = 0;
            if (snowballSnow!=0) {
                interim = Math.floor(snowballSnow/snowballTime);
            }
            if (snowballTime==0) {
                interim = 1;
            }

            double currentSnowballValue = Math.pow(interim, snowballQuality);

            if (currentSnowballValue>maxSnowballValue) {
                maxSnowballValue = (int) currentSnowballValue;
                maxSnow = snowballSnow;
                maxTime = snowballTime;
                maxQuality = (int) snowballQuality;
            }
        }

        if (numOfSnowballs>0) {
            System.out.printf("%d : %d = %d (%d)", maxSnow, maxTime, maxSnowballValue, maxQuality);
        }

    }
}
