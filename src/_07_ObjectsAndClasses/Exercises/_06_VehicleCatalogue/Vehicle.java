package _07_ObjectsAndClasses.Exercises._06_VehicleCatalogue;

public class Vehicle {
    private String typeOfVehicle;
    private String modelOfVehicle;
    private String colour;
    private int horsepower;

    public Vehicle(String typeOfVehicle, String modelOfVehicle, String colour, int horsepower) {
        this.typeOfVehicle = typeOfVehicle;
        this.modelOfVehicle = modelOfVehicle;
        this.colour = colour;
        this.horsepower = horsepower;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public String getModelOfVehicle() {
        return modelOfVehicle;
    }

    public void setModelOfVehicle(String modelOfVehicle) {
        this.modelOfVehicle = modelOfVehicle;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }
}
