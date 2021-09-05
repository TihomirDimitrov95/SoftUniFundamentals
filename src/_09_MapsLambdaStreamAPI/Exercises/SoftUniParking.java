package _09_MapsLambdaStreamAPI.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> licenseRegister = new LinkedHashMap<>();

        int numOfCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numOfCommands; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            String username = tokens[1];

            if (command.equals("register")) {
                String licensePlateNumber = tokens[2];
                if (licenseRegister.containsKey(username)) {
                    System.out.printf("ERROR: already registered with plate number %s%n", licenseRegister.get(username));
                } else {
                    licenseRegister.put(username, licensePlateNumber);
                    System.out.printf("%s registered %s successfully%n", username, licensePlateNumber);
                }
            } else if (command.equals("unregister")) {
                if (!licenseRegister.containsKey(username)) {
                    System.out.printf("ERROR: user %s not found%n", username);
                } else {
                    licenseRegister.remove(username);
                    System.out.printf("%s unregistered successfully%n", username);
                }
            }
        }

        for (Map.Entry<String, String> entry : licenseRegister.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }


    }
}
