package _01_BasicSyntax.Exercises;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int studentCount = Integer.parseInt(scanner.nextLine());
        double lightSaberPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        int freeBelts = studentCount/6;

        double sumRequired = lightSaberPrice*Math.ceil(studentCount*1.1) + robePrice*studentCount + beltPrice*(studentCount-freeBelts);

        if (sumRequired<=budget) {
            System.out.printf("The money is enough - it would cost %.2flv.", sumRequired);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", sumRequired-budget);
        }
    }
}
