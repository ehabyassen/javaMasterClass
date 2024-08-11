package com.lp.challenge;

import java.util.Comparator;

public class LPAStudent extends Student {

    private final double percentComplete;

    public LPAStudent() {
        this.percentComplete = random.nextDouble(0, 100.001);
    }

    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(), percentComplete);
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        if (fieldName.equalsIgnoreCase("percentComplete")) {
            return percentComplete <= Double.parseDouble(value);
        }
        return super.matchFieldValue(fieldName, value);
    }

    public double getPercentComplete() {
        return percentComplete;
    }

    public static Comparator<LPAStudent> compareByPercentComplete() {
        return Comparator.comparing(LPAStudent::getPercentComplete);
    }
}
