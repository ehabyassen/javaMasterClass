package com.lp.interfaces;

public class Test {

    public static void main(String[] args) {
//        inFlight(new Jet());
        orbit(new Jet());
    }

    private static void orbit(FlightEnabled flier) {
        flier.takeOff();
        flier.fly();
        flier.land();
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
