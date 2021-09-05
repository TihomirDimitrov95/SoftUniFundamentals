package _04_Methods.Exercises;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        boolean isValidated = validatePassword(password);
        if (isValidated) {
            System.out.println("Password is valid");
        }
    }

    private static boolean validatePassword(String password) {
        boolean isValidate = true;

        boolean firstCheck = isPasswordLengthCorrect(password);
        boolean secondCheck = isPasswordLettersAndDigits(password);
        boolean thirdCheck = checkIfPasswordHasTwoOrMoreDigits(password);

        if (firstCheck==true && secondCheck==true && thirdCheck==true) {
            isValidate = true;
        } else {
            isValidate = false;
        }

        return isValidate;
    }

    private static boolean checkIfPasswordHasTwoOrMoreDigits(String password) {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            int currentChar = password.charAt(i);
            if (Character.isDigit(currentChar)) {
                count++;
            }
        }
        if (count>=2) {
            return true;
        } else {
            System.out.println("Password must have at least 2 digits");
            return false;
        }
    }

    private static boolean isPasswordLettersAndDigits(String password) {
        boolean isValid = true;
        for (int i = 0; i < password.length(); i++) {
            int currentChar = password.charAt(i);
            if (currentChar<47 || currentChar>57 && currentChar<65 || currentChar>90 && currentChar<97 || currentChar>122) {
                System.out.println("Password must consist only of letters and digits");
                isValid = false;
                break;
            } else if (i == password.length()-1) {
                isValid = true;
            }
        }
        return isValid;
    }

    private static boolean isPasswordLengthCorrect(String password) {
        if (password.length()<6 || password.length()>10) {
            System.out.println("Password must be between 6 and 10 characters");
            return false;
        } else {
            return true;
        }
    }
}
