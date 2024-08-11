package academy.learnprogramming.polymorphismChallenge;

public class GasPoweredCar extends Car {

    private final double avgKmPerLiter;
    private final int cylinders;

    public GasPoweredCar(double avgKmPerLiter, int cylinders) {
        super("This is a Gas powered car with average " + avgKmPerLiter + " km per liter and " + cylinders + " cylinders");
        this.avgKmPerLiter = avgKmPerLiter;
        this.cylinders = cylinders;
    }

    public double getAvgKmPerLiter() {
        return avgKmPerLiter;
    }

    public int getCylinders() {
        return cylinders;
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("Starting engine and keeping it running for 3 minutes before driving...");
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("Press gas pedal to drive the car...");
    }
}
