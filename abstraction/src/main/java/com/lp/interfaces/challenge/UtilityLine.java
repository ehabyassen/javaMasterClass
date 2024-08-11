package com.lp.interfaces.challenge;

import static com.lp.interfaces.challenge.Color.*;
import static com.lp.interfaces.challenge.GeometryType.LINE;
import static com.lp.interfaces.challenge.LineMarker.*;

public class UtilityLine implements Mappable {

    private final String name;
    private final Utility utility;

    public UtilityLine(String name, Utility utility) {
        this.name = name;
        this.utility = utility;
    }

    @Override
    public GeometryType getGeometryType() {
        return LINE;
    }

    @Override
    public String getIconType() {
        return switch (utility) {
            case ELECTRICAL -> RED + " " + DASHED;
            case FIBER_OPTIC -> GREEN + " " + DOTTED;
            case GAS -> ORANGE + " " + SOLID;
            case WATER -> BLUE + " " + SOLID;
            default -> BLACK + " " + SOLID;
        };
    }

    @Override
    public String getLabel() {
        return name + " (" + utility + ")";
    }

    public String toJSON() {
        return (Mappable.super.toJSON() + """
                , "name": "%s" """.formatted(name)) + """
                , "utility": "%s" """.formatted(utility);
    }
}
