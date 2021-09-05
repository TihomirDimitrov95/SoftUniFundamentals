package _07_ObjectsAndClasses.MoreExercises._01_CompanyRoster;

public class Departments {
    private String name;
    private Double totalSalaryForDepartment;
    private int numberOfEmployees;
    private Double averageSalary;

    public Departments(String name, Double totalSalaryForDepartment, int numberOfEmployees, double averageSalary) {
        this.name = name;
        this.totalSalaryForDepartment = totalSalaryForDepartment;
        this.numberOfEmployees = numberOfEmployees;
        this.averageSalary = averageSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotalSalaryForDepartment() {
        return totalSalaryForDepartment;
    }

    public void setTotalSalaryForDepartment(Double totalSalaryForDepartment) {
        this.totalSalaryForDepartment = totalSalaryForDepartment;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public Double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(Double averageSalary) {
        this.averageSalary = averageSalary;
    }
}
