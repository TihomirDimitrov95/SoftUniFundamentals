package _05_Lists.MoreExercises;

import java.util.Scanner;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] numArray = new int[input.length];

        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = Integer.parseInt(input[i]);
        }

        double firstRacerTime = 0;
        double secondRacerTime = 0;
        for (int i = 0; i < numArray.length/2; i++) {
            if (numArray[i]!=0) {
                firstRacerTime+=numArray[i];
            } else {
                firstRacerTime*=0.8;
            }

            if (numArray[numArray.length-1-i]!=0) {
                secondRacerTime+=numArray[numArray.length-1-i];
            } else {
                secondRacerTime*=0.8;
            }
        }

        if (firstRacerTime<secondRacerTime) {
            System.out.printf("The winner is left with total time: %.1f", firstRacerTime);
        } else {
            System.out.printf("The winner is right with total time: %.1f", secondRacerTime);
        }

    }
}
