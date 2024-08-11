package academy.learnprogramming.inheritanceChallenge;

public class Car extends Vehicle {

    private String transmissionType;
    private int horsePower;
    private int numberOfDoors;
    private int topSpeed;
    private int numberOfGears;
    private int currentGear;
    private int currentSpeed;
    private int steeringAngle;

    public Car(String manufacturer, String model, String yearOfManufacturing, String transmissionType, int horsePower,
               int numberOfDoors, int topSpeed, int numberOfGears) {
        super(manufacturer, model, yearOfManufacturing);
        this.transmissionType = transmissionType;
        this.horsePower = horsePower;
        this.numberOfDoors = numberOfDoors;
        this.topSpeed = topSpeed;
        this.numberOfGears = numberOfGears;
        this.currentGear = 0;
        this.currentSpeed = 0;
        this.steeringAngle = 0;
    }

    //region getters & setters
    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public void setCurrentGear(int currentGear) {
        this.currentGear = currentGear;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
    //endregion

    public void steerRight() {
        if (steeringAngle <= 170) {
            steeringAngle += 10;
            System.out.println("Steered Right. Current steering angle is: " + steeringAngle);
        } else {
            System.out.println("Cannot steer more to the right. Current steering angle is: " + steeringAngle);
        }
    }

    public void steerLeft() {
        if (steeringAngle >= -170) {
            steeringAngle -= 10;
            System.out.println("Steered Left. Current steering angle is: " + steeringAngle);
        } else {
            System.out.println("Cannot steer more to the left. Current steering angle is: " + steeringAngle);
        }
    }

    public void changeGear(int newGear) {
        if (newGear <= numberOfGears) {
            currentGear = newGear;
            System.out.println("Current gear is: " + currentGear);
        } else {
            System.out.println("Cannot set gear to: " + newGear + " . Max gear is " + numberOfGears);
        }
    }

    public void speedUp() {
        if (currentSpeed <= topSpeed - 10) {
            currentSpeed += 10;
            System.out.println("Sped up. Current speed is: " + currentSpeed);
        } else {
            System.out.println("Cannot speed up. Top speed [" + topSpeed + "] reached. Current speed: " + currentSpeed);
        }
    }

    public void speedDown() {
        if (currentSpeed >= 10) {
            currentSpeed -= 10;
            System.out.println("Sped down. Current speed is: " + currentSpeed);
        } else {
            System.out.println("Cannot speed down. Car is stopped. Current speed: " + currentSpeed);
        }
    }
}

