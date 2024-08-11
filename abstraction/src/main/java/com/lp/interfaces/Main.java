package com.lp.interfaces;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Bird bird = new Bird();
        Animal animal = bird;
        FlightEnabled flier = bird;
        Trackable trackable = bird;

        animal.move();
//        flier.move();
//        trackable.move();

        flier.takeOff();
        flier.fly();
        trackable.track();
        bird.land();

        System.out.println("=".repeat(30));
        inFlight(flier);

        System.out.println("=".repeat(30));
        inFlight(new Jet());

        System.out.println("=".repeat(30));
        Trackable truck = new Truck();
        truck.track();

        System.out.println("=".repeat(30));

        double kmsTraveled = 100;
        double milesTraveled = kmsTraveled * FlightEnabled.KM_TO_MILES;
        System.out.printf("The truck traveled %.2f km or %.2f miles%n", kmsTraveled, milesTraveled);

        System.out.println("=".repeat(30));

        List<FlightEnabled> fliers = new ArrayList<>();
        fliers.add(bird);
    }

    private static void inFlight(FlightEnabled flier) {
        flier.takeOff();
        flier.fly();
        if (flier instanceof Trackable tracked) {
            tracked.track();
        }
        flier.land();
    }
}
