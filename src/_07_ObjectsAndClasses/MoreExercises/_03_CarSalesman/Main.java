package _07_ObjectsAndClasses.MoreExercises._03_CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfEngines = Integer.parseInt(scanner.nextLine());
        List<Engine> engineList = new ArrayList<>();

        for (int i = 0; i < numberOfEngines; i++) {
            String input = scanner.nextLine();
            String model = input.split("\\s+")[0];
            int power = Integer.parseInt(input.split("\\s+")[1]);

            int displacement = -1;
            String efficiency = "";
            if (input.split("\\s+").length==2) {
                displacement = -1;
                efficiency = "n/a";
            } else if (input.split("\\s+").length==3) {
                if (Character.isDigit(input.split("\\s+")[2].charAt(0))) {
                    displacement = Integer.parseInt(input.split("\\s+")[2]);
                    efficiency = "n/a";
                } else {
                    displacement = -1;
                    efficiency = input.split("\\s+")[2];
                }
            } else if (input.split("\\s+").length==4) {
                displacement = Integer.parseInt(input.split("\\s+")[2]);
                efficiency = input.split("\\s+")[3];
            }


            Engine currentEngine = new Engine(model, power, displacement, efficiency);
            engineList.add(currentEngine);
        }

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            String input = scanner.nextLine();
            String model = input.split("\\s+")[0];

            Engine engine = new Engine("dummy", -1, -1, "C");
            for (Engine eng : engineList)  {
                if (eng.getModel().equals(input.split("\\s+")[1])) {
                    engine = eng;
                }
            }

            int weight = -1;
            String color = "n/a";
            if (input.split("\\s+").length==3) {
                if (Character.isDigit(input.split("\\s+")[2].charAt(0))) {
                    weight = Integer.parseInt(input.split("\\s+")[2]);
                } else {
                    color = input.split("\\s+")[2];
                }
            } else if (input.split("\\s+").length==4) {
                weight = Integer.parseInt(input.split("\\s+")[2]);
                color = input.split("\\s+")[3];
            }

            Car currentCar = new Car(model, engine, weight, color);
            carList.add(currentCar);
        }

        for (Car car : carList) {
            System.out.println(car);
        }
    }
}
