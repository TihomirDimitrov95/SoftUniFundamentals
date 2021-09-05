package _09_MapsLambdaStreamAPI.Exercises;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> studentMap = new LinkedHashMap<>();

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfStudents; i++) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            studentMap.putIfAbsent(studentName, new ArrayList<>());
            studentMap.get(studentName).add(grade);
        }

        studentMap.entrySet().stream()
                .filter(e -> {
                    double average = 0;
                    for (Double grade: e.getValue()) {
                        average += grade;
                    }
                    average /= e.getValue().size();
                    return average>=4.5;
                })
                .sorted((left, right) -> {
                    int result = 0;
                    double averageLeft = 0;
                    for (Double grade: left.getValue()) {
                        averageLeft += grade;
                    }
                    averageLeft /= left.getValue().size();

                    double averageRight = 0;
                    for (Double grade: right.getValue()) {
                        averageRight += grade;
                    }
                    averageRight /= right.getValue().size();

                    if (averageRight>averageLeft) {
                        result = 1;
                    } else if (averageRight<averageLeft) {
                        result = -1;
                    } else {
                        result = 0;
                    }

                    return result;
                } )
                .forEach(e -> {
                    double average = 0;
                    for (Double grade :
                            e.getValue()) {
                        average += grade;
                    }
                    average /= e.getValue().size();

                    System.out.printf("%s -> %.2f%n", e.getKey(), average);
                });
    }
}
