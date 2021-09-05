package _07_ObjectsAndClasses.Exercises._07_OrderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String name = input.split("\\s+")[0];
            String identityNumber = input.split("\\s+")[1];
            int age = Integer.parseInt(input.split("\\s+")[2]);

            Person currentPerson = new Person(name, identityNumber, age);
            personList.add(currentPerson);
            input = scanner.nextLine();
        }

        personList.sort(Comparator.comparing(Person::getAge));

        for (Person person: personList) {
            System.out.println(person);
        }

    }
}
