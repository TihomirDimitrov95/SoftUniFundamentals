package _02_DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tankCapacity = 255;
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int litrersInput = Integer.parseInt(scanner.nextLine());
            if (litrersInput<=tankCapacity) {
                tankCapacity -= litrersInput;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }

        System.out.println(255-tankCapacity);

    }
}
