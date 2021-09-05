package _02_DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        int elevatorCapacity = Integer.parseInt(scanner.nextLine());
        int count = 0;

        while (numberOfPeople>0) {
            numberOfPeople -= elevatorCapacity;
            count++;
        }

        System.out.println(count);
    }
}
