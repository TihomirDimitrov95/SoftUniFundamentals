package _07_ObjectsAndClasses.MoreExercises._03_CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        String optionalWeight = "";
        if (weight==-1) {
            optionalWeight = "n/a";
        } else {
            optionalWeight = Integer.toString(weight);
        }

        String optionalDisplacement = "";
        if (engine.getDisplacement()==-1) {
            optionalDisplacement = "n/a";
        } else {
            optionalDisplacement = Integer.toString(engine.getDisplacement());
        }

        String output = String.format("%s:%n%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s", model, engine.getModel() ,engine.getPower(), optionalDisplacement, engine.getEfficiency(), optionalWeight, color);

        return output;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }
}
