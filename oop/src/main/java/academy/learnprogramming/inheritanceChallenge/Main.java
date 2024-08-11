package academy.learnprogramming.inheritanceChallenge;

public class Main {

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Bmw", "i123", "1990");


        Car c1 = new Car("Bmw", "m1", "2022", "manual", 1000,
                2, 300, 8);
        c1.changeGear(9);
        c1.changeGear(7);
        for (int i = 0; i < 31; i++) {
            c1.speedUp();
        }

        for (int i = 0; i < 33; i++) {
            c1.speedDown();
        }

        for (int i = 0; i < 20; i++) {
            c1.steerRight();
        }

        for (int i = 0; i < 40; i++) {
            c1.steerLeft();
        }

        MarsRover r1 = new MarsRover("Nasa", "A1", "2030", "auto",
                15, 0, 20, 1);

        r1.speedUp();
        r1.speedUp();
        r1.speedUp();

        r1.deploySolarPanel();
        r1.deploySolarPanel();
        r1.undeploySolarPanel();
        r1.undeploySolarPanel();

        r1.speedDown();
        r1.speedDown();
        r1.speedDown();
        r1.speedDown();
        r1.speedDown();
    }
}
