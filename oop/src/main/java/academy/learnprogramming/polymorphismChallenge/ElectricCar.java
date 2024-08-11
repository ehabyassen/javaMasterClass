package academy.learnprogramming.polymorphismChallenge;

public class ElectricCar extends Car {

    private final double avgKmPerCharge;
    private final int batterySizeInKW;

    public ElectricCar(double avgKmPerCharge, int batterySizeInKW) {
        super("This is an electric car with average " + avgKmPerCharge + " km per charge and a " + batterySizeInKW + " KW battery");
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySizeInKW = batterySizeInKW;
    }

    public double getAvgKmPerCharge() {
        return avgKmPerCharge;
    }

    public int getBatterySizeInKW() {
        return batterySizeInKW;
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("Starting engine by pressing button on the dashboard...");
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("Press the accelerator to drive...");
    }
}
