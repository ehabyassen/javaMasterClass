package com.learn.innerClasses;

import java.util.ArrayList;
import java.util.List;

public class GearBox {

    private List<Gear> gears;
    private int maxGear;
    private int currentGear = 0;

    public GearBox(int maxGear) {
        this.maxGear = maxGear;
        this.gears = new ArrayList<>();
        Gear neutral = new Gear(0, 0.0);
        this.gears.add(neutral);
    }

    public void addGear(int gearNumber, double ratio) {
        this.gears.add(new Gear(gearNumber, ratio));
    }

    private class Gear {
        private int gearNumber;
        private double ratio;

        private Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }

        public double drive(int revs) {
            return revs * ratio;
        }
    }
}
