package _01_BasicSyntax.Exercises;

import java.util.Scanner;

public class Login {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        String password = scanner.nextLine();
        boolean isValid = false;
        int count = 0;

        while (!isValid) {
            if (username.length()!=password.length()) {
                count++;
                if (count==4) {
                    System.out.printf("User %s blocked!", username);
                    isValid = true;
                } else {
                    isValid = false;
                    System.out.println("Incorrect password. Try again.");
                    password = scanner.nextLine();
                }
                continue;
            }
            for (int i = 0; i < username.length(); i++) {
                if (username.charAt(i) != password.charAt(password.length()-1-i)) {
                    count++;
                    if (count==4) {
                        System.out.printf("User %s blocked!", username);
                        isValid = true;
                        break;
                    }
                    isValid = false;
                    System.out.println("Incorrect password. Try again.");
                    password = scanner.nextLine();
                    break;
                } else if (i==username.length()-1) {
                    isValid = true;
                    System.out.printf("User %s logged in.", username);
                }
            }
        }

    }
}
