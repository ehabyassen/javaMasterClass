package academy.learnprogramming.inheritanceChallenge;

public class MarsRover extends Car {

    private boolean solarPanelDeployed;

    public MarsRover(String manufacturer, String model, String yearOfManufacturing, String transmissionType,
                     int horsePower, int numberOfDoors, int topSpeed, int numberOfGears) {
        super(manufacturer, model, yearOfManufacturing, transmissionType, horsePower, numberOfDoors, topSpeed, numberOfGears);
        solarPanelDeployed = false;
    }

    public boolean isSolarPanelDeployed() {
        return solarPanelDeployed;
    }

    public void deploySolarPanel() {
        if (solarPanelDeployed) {
            System.out.println("Solar panel is already deployed.");
        } else {
            solarPanelDeployed = true;
            System.out.println("Deployed solar panel successfully.");
        }
    }

    public void undeploySolarPanel() {
        if (solarPanelDeployed) {
            solarPanelDeployed = false;
            System.out.println("Un-deployed solar panel successfully.");
        } else {
            System.out.println("Solar panel is already un-deployed.");
        }
    }
}
