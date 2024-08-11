package academy.learnprogramming.polymorphismChallenge;

public class Car {

    private final String description;

    public Car(String description) {
        this.description = description;
    }

    public void startEngine() {
        System.out.println("Starting an engine of a " + this.getClass().getSimpleName());
    }

    public void drive() {
        System.out.println("Driving a " + this.getClass().getSimpleName());
        runEngine();
    }

    protected void runEngine() {
        System.out.println("Running an engine of a " + this.getClass().getSimpleName());
    }

    public String getDescription() {
        return description;
    }
}
