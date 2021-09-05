package _09_MapsLambdaStreamAPI.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companyMap = new LinkedHashMap<>();

        String[] input = scanner.nextLine().split(" -> ");
        while (!input[0].equals("End")) {
            String companyName = input[0];
            String employeeID = input[1];

            companyMap.putIfAbsent(companyName, new ArrayList<>());

            if (!companyMap.get(companyName).contains(employeeID)) {
                companyMap.get(companyName).add(employeeID);
            }

            input = scanner.nextLine().split(" -> ");
        }

        companyMap.entrySet().stream()
                .sorted((left, right) -> left.getKey().compareTo(right.getKey()))
                .forEach(e -> {
                    System.out.println(e.getKey());
                    for (String employee :
                            e.getValue()) {
                        System.out.println("-- " + employee);
                    }
                });

    }
}
