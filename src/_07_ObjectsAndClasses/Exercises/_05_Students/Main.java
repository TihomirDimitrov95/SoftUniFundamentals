package _07_ObjectsAndClasses.Exercises._05_Students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> studentList = new ArrayList<>();

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfStudents; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            double grade = Double.parseDouble(tokens[2]);

            Student student = new Student(firstName, lastName, grade);
            studentList.add(student);
        }

        studentList.sort(Comparator.comparing(Student::getGrade));

        for (int i = studentList.size()-1; i >= 0; i--) {
            System.out.println(studentList.get(i));
        }
    }
}
