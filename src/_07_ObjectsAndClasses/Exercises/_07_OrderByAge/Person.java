package _07_ObjectsAndClasses.Exercises._07_OrderByAge;

public class Person {
    private String name;
    private String identityNumber;
    private int age;

    public Person(String name, String identityNumber, int age) {
        this.name = name;
        this.identityNumber = identityNumber;
        this.age = age;
    }

    public int getAge () {
        return this.age;
    }

    public String toString() {
        return String.format("%s with ID: %s is %d years old.", name, identityNumber, age);
    }
}
