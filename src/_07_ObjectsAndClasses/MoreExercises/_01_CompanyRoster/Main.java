package _07_ObjectsAndClasses.MoreExercises._01_CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfEmployees = Integer.parseInt(scanner.nextLine());

        List<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < numberOfEmployees; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];

            Employee currentEmployee = new Employee(name, salary, position, department);

            if (input.length==5) {
                if (input[4].contains("@")) {
                    currentEmployee.setEmail(input[4]);
                    currentEmployee.setAge(-1);
                } else {
                    currentEmployee.setAge(Integer.parseInt(input[4]));
                    currentEmployee.setEmail("n/a");
                }
            } else if (input.length==6) {
                currentEmployee.setEmail(input[4]);
                currentEmployee.setAge(Integer.parseInt(input[5]));
            } else if (input.length==4) {
                currentEmployee.setEmail("n/a");
                currentEmployee.setAge(-1);
            }

            employeeList.add(currentEmployee);
        }

        String highestPaidDepartment = getHighestPaidDepartment(employeeList);

        List<Employee> sortedList = employeeList.stream().filter(employee -> employee.getDepartment().equals(highestPaidDepartment)).collect(Collectors.toList());
        sortedList.sort(Comparator.comparing(Employee::getSalary).reversed());

        System.out.printf("Highest Average Salary: %s%n", highestPaidDepartment);
        for (Employee employee : sortedList) {
            System.out.println(employee);
        }

    }

    private static String getHighestPaidDepartment(List<Employee> employeeList) {
        List<Departments> departmentsList = new ArrayList<>();

        for (Employee employee : employeeList) {
            String departmentOfCurrentEmployee = employee.getDepartment();
            if (departmentsList.size()==0) {
                Departments currentDepartment = new Departments(departmentOfCurrentEmployee, employee.getSalary(), 1, employee.getSalary());
                departmentsList.add(currentDepartment);

            } else {
                boolean isNewDepartment = true;
                for (Departments dep : departmentsList) {
                    if (dep.getName().equals(departmentOfCurrentEmployee)) {
                        isNewDepartment = false;

                        double newTotalSalaries = employee.getSalary() + dep.getTotalSalaryForDepartment();
                        int newNumberOfEmployees = dep.getNumberOfEmployees() +1;
                        double newAverageSalary = newTotalSalaries/newNumberOfEmployees;

                        dep.setTotalSalaryForDepartment(newTotalSalaries);
                        dep.setNumberOfEmployees(newNumberOfEmployees);
                        dep.setAverageSalary(newAverageSalary);

                        break;
                    }
                }
                if (isNewDepartment) {
                    Departments currentDepartment = new Departments(departmentOfCurrentEmployee, employee.getSalary(), 1, employee.getSalary());
                    departmentsList.add(currentDepartment);
                }
            }
        }

        departmentsList.sort(Comparator.comparing(Departments::getAverageSalary).reversed());

        return departmentsList.get(0).getName();
    }
}
