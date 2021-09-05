package _07_ObjectsAndClasses.Exercises._06_VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> vehiclesList = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            String type = tokens[0];
            String model = tokens[1];
            String colour = tokens[2];
            int horsePower = Integer.parseInt(tokens[3]);

            Vehicle currentVehicle = new Vehicle(type, model, colour, horsePower);
            vehiclesList.add(currentVehicle);

            input = scanner.nextLine();
        }


        String model = scanner.nextLine();
        while (!model.equals("Close the Catalogue")) {

            for (Vehicle vehicle : vehiclesList) {
                if (model.equals(vehicle.getModelOfVehicle())) {
                    if (vehicle.getTypeOfVehicle().equals("car")) {
                        System.out.println("Type: Car");
                    } else {
                        System.out.println("Type: Truck");
                    }
                    System.out.printf("Model: %s%n", vehicle.getModelOfVehicle());
                    System.out.printf("Color: %s%n", vehicle.getColour());
                    System.out.printf("Horsepower: %s%n", vehicle.getHorsepower());
                }
            }

            model = scanner.nextLine();
        }

        double carHorsepowerTotal = 0;
        int carsCount = 0;

        double truckHorsepowerTotal = 0;
        int trucksCount = 0;

        for (Vehicle vehicle :
                vehiclesList) {
            if (vehicle.getTypeOfVehicle().equals("car")) {
                carHorsepowerTotal += vehicle.getHorsepower();
                carsCount++;
            } else {
                truckHorsepowerTotal += vehicle.getHorsepower();
                trucksCount++;
            }
        }

        double carAverage = 0;
        if (carsCount>0) {
            carAverage = carHorsepowerTotal/carsCount;
        }

        double trucksAverage = 0;
        if (trucksCount>0) {
            trucksAverage = truckHorsepowerTotal/trucksCount;
        }

        System.out.printf("Cars have average horsepower of: %.2f.%n", carAverage);
        System.out.printf("Trucks have average horsepower of: %.2f.", trucksAverage);

    }
}
