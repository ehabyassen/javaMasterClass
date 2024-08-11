package com.lp.interfaces;

import java.util.Date;

public interface FlightEnabled {

    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;

    void takeOff();

    void land();

    void fly();

    default FlightStages transition(FlightStages stage) {
//        System.err.println("transition is not implemented in " + getClass().getSimpleName());
//        return null;
        FlightStages nextStage = stage.getNextStage();
        System.out.println("transitioning from " + stage + " to " + nextStage);
        return nextStage;
    }
}

interface OrbitEarth extends FlightEnabled {
    void achieveOrbit();

    private static void log(String desc) {
        Date today = new Date();
        System.out.println(today + ": " + desc);
    }

    private static void logStage(FlightStages stage, String desc) {
        log(stage + ": " + desc);
    }

    @Override
    default FlightStages transition(FlightStages stage) {
        FlightStages next = FlightEnabled.super.transition(stage);
        logStage(next, "Beginning transition to " + next);
        return next;
    }
}

class Satellite implements OrbitEarth {

    FlightStages stage = FlightStages.GROUNDED;

    @Override
    public void achieveOrbit() {
        transition("Orbit Achieved!");
    }

    @Override
    public void takeOff() {
        transition("Taking Off");
    }

    @Override
    public void land() {
        transition("Landing");
    }

    @Override
    public void fly() {
        achieveOrbit();
        transition("Data Collection while Orbiting");
    }

    public void transition(String desc) {
        System.out.println(desc);
        stage = transition(stage);
        stage.track();
    }
}

enum FlightStages implements Trackable {
    GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;

    @Override
    public void track() {
        if (!this.equals(GROUNDED)) {
            System.out.println("Monitoring " + this);
        }
    }

    public FlightStages getNextStage() {
        FlightStages[] stages = values();
        return stages[(ordinal()) + 1 % stages.length];
    }
}

record Dragon(String name, String type) implements FlightEnabled {

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}