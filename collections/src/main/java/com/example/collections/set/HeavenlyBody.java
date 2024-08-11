package com.example.collections.set;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {

    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final BodyType bodyType;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.bodyType = BodyType.START;
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(satellites);
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public boolean addSatellite(HeavenlyBody satellite) {
        return satellites.add(satellite);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if(o instanceof HeavenlyBody) {
            HeavenlyBody o1 = (HeavenlyBody) o;
            if (this.name.equals(o1.getName())) {
                return this.bodyType == o1.getBodyType();
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.name.hashCode() + 57 + this.bodyType.hashCode();
    }

    @Override
    public String toString() {
        return name + ": " + bodyType + ", " + orbitalPeriod;
    }
}
