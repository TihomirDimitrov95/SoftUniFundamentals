package _07_ObjectsAndClasses.Exercises._03_OpinionPoll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfPeople; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            personList.add(person);
        }

        List<String> peopleOverThirty = new ArrayList<>();
        for (Person person : personList) {
            if (person.getAge() > 30) {
                peopleOverThirty.add(person.getName());
            }
        }

        Collections.sort(peopleOverThirty);
        for (String people : peopleOverThirty) {
            for (Person person : personList) {
                if (people.equals(person.getName())) {
                    System.out.printf("%s - %d%n", person.getName(), person.getAge());
                }
            }
        }
    }
}
