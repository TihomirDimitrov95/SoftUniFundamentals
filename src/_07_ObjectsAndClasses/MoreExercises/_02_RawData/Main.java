package _07_ObjectsAndClasses.MoreExercises._02_RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfVehicles = Integer.parseInt(scanner.nextLine());

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < numberOfVehicles; i++) {
            String input = scanner.nextLine();
            String model = input.split("\\s+")[0];
            int engineSpeed = Integer.parseInt(input.split("\\s+")[1]);
            int enginePower = Integer.parseInt(input.split("\\s+")[2]);
            int cargoWeight = Integer.parseInt(input.split("\\s+")[3]);
            String cargoType = input.split("\\s+")[4];
            double tyrePressureOne = Double.parseDouble(input.split("\\s+")[5]);
            int tyreAgeOne = Integer.parseInt(input.split("\\s+")[6]);
            double tyrePressureTwo = Double.parseDouble(input.split("\\s+")[7]);
            int tyreAgeTwo = Integer.parseInt(input.split("\\s+")[8]);
            double tyrePressureThree = Double.parseDouble(input.split("\\s+")[9]);
            int tyreAgeThree = Integer.parseInt(input.split("\\s+")[10]);
            double tyrePressureFour = Double.parseDouble(input.split("\\s+")[11]);
            int tyreAgeFour = Integer.parseInt(input.split("\\s+")[12]);

            Engine currentEngine = new Engine(engineSpeed, enginePower);
            Cargo currentCargo = new Cargo(cargoWeight, cargoType);
            Tire currentTires = new Tire(tyrePressureOne, tyreAgeOne, tyrePressureTwo, tyreAgeTwo, tyrePressureThree, tyreAgeThree,tyrePressureFour, tyreAgeFour);

            Car currentCar = new Car(model, currentEngine, currentCargo, currentTires);

            carList.add(currentCar);
        }

        String command = scanner.nextLine();

        if (command.equals("fragile")) {
            List<Car> sortedList = carList.stream().filter(Car -> Car.getCargo().getType().equals("fragile")).collect(Collectors.toList());

            List<String> fragileCarsList = executeFragileCommand(sortedList);
            for (String car : fragileCarsList) {
                System.out.println(car);
            }
        } else if (command.equals("flamable")) {
            List<Car> sortedList = carList.stream().filter(Car -> Car.getCargo().getType().equals("flamable")).collect(Collectors.toList());

            List<String> flamableCarsList = executeFlamableCommand(sortedList);
            for (String car : flamableCarsList) {
                System.out.println(car);
            }
        }
    }

    private static List<String> executeFlamableCommand(List<Car> sortedList) {
        List<String> result = new ArrayList<>();
        for (Car car : sortedList) {
            if (car.getEngine().getPower()>250) {
                result.add(car.getModel());
            }
        }
        return result;
    }

    private static List<String> executeFragileCommand(List<Car> sortedList) {
        List<String> result = new ArrayList<>();
        for (Car car : sortedList) {
            if (car.getTires().getPressure1()<1 || car.getTires().getPressure2()<1 || car.getTires().getPressure3()<1 || car.getTires().getPressure4()<1) {
                result.add(car.getModel());
            }
        }

        return result;
    }
}
