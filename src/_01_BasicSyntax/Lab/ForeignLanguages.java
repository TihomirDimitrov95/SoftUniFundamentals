package _01_BasicSyntax.Lab;

import java.util.Scanner;

public class ForeignLanguages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String countryName = scanner.nextLine();

        switch (countryName.toLowerCase()) {
            case "england":
            case "usa":
                System.out.println("English");
                break;
            case "spain":
            case "argentina":
            case "mexico":
                System.out.println("Spanish");
                break;
            default:
                System.out.println("unknown");
                break;
        }
    }
}
