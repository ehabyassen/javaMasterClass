package academy.learnprogramming.polymorphismChallenge;

public class HybridCar extends Car {

    private final double avgKmPerLiter;
    private final int batterySizeInKW;
    private final int cylinders;

    public HybridCar(double avgKmPerLiter, int batterySizeInKW, int cylinders) {
        super("This is a hybrid car with average " + avgKmPerLiter + " km per liter, a "
                + batterySizeInKW + " KW battery and " + cylinders + " cylinders");
        this.avgKmPerLiter = avgKmPerLiter;
        this.batterySizeInKW = batterySizeInKW;
        this.cylinders = cylinders;
    }

    public double getAvgKmPerLiter() {
        return avgKmPerLiter;
    }

    public int getBatterySizeInKW() {
        return batterySizeInKW;
    }

    public int getCylinders() {
        return cylinders;
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("Starting engine on gas then switch to electric when starting to move...");
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("Press the accelerator to drive, now running on battery...");
    }
}
