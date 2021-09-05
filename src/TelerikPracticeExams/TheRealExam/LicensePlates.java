package TelerikPracticeExams.TheRealExam;

import java.util.Scanner;

public class LicensePlates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String allowedLetters = scanner.nextLine().replaceAll(",", "");
        int numberOfLicensePlates = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfLicensePlates; i++) {
            String licensePlate = scanner.nextLine();

            if (checkIfLicensePlateIsValid(licensePlate, allowedLetters)) {
                System.out.println(licensePlate);
            }
        }
    }

    private static boolean checkIfLicensePlateIsValid(String licensePlate, String allowedLetters) {
        boolean check = true;

        for (int i = 0; i < licensePlate.length(); i++) {
            if (i<2 || i>5) {
                if (!allowedLetters.contains(Character.toString(licensePlate.charAt(i)))) {
                    check = false;
                    break;
                }
            } else {
                if (!Character.isDigit(licensePlate.charAt(i))) {
                    check = false;
                    break;
                }
            }
        }

        return check;
    }
}
