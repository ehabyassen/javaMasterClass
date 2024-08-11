package com.lp.interfaces.challenge;

import static com.lp.interfaces.challenge.Color.*;
import static com.lp.interfaces.challenge.GeometryType.POINT;
import static com.lp.interfaces.challenge.PointMarker.*;

public class Building implements Mappable {

    private final String name;
    private final Usage usage;

    public Building(String name, Usage usage) {
        this.name = name;
        this.usage = usage;
    }

    @Override
    public GeometryType getGeometryType() {
        return POINT;
    }

    @Override
    public String getIconType() {
        return switch (usage) {
            case ENTERTAINMENT -> GREEN + " " + TRIANGLE;
            case GOVERNMENT -> RED + " " + STAR;
            case RESIDENTIAL -> BLUE + " " + SQUARE;
            case SPORT -> ORANGE + " " + PUSH_PIN;
            default -> BLACK + " " + CIRCLE;
        };
    }

    @Override
    public String getLabel() {
        return name + " (" + usage + ")";
    }

    public String toJSON() {
        return (Mappable.super.toJSON() + """
                , "name": "%s" """.formatted(name)) + """
                , "usage": "%s" """.formatted(usage);
    }
}
