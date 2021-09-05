package _09_MapsLambdaStreamAPI.Exercises;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> coursesMap = new LinkedHashMap<>();

        String[] tokens = scanner.nextLine().split(" : ");
        while(!tokens[0].equals("end")) {
            String courseName = tokens[0];
            String studentName = tokens[1];

            if (!coursesMap.containsKey(courseName)) {
                coursesMap.put(courseName, new ArrayList<>());
            }
            coursesMap.get(courseName).add(studentName);

            tokens = scanner.nextLine().split(" : ");
        }

        coursesMap.entrySet()
                .stream()
                .sorted((left, right) -> {
                    int result = 0;
                    if (right.getValue().size()>left.getValue().size()) {
                        result = 1;
                    } else if (right.getValue().size()<left.getValue().size()) {
                        result = -1;
                    }
                    return result;
                }).forEach(e -> {
            System.out.printf("%s: %d%n", e.getKey(), e.getValue().size());
            Collections.sort(e.getValue());
            for (String name :
                    e.getValue()) {
                System.out.printf("-- %s%n", name);
            }
        });


    }
}
