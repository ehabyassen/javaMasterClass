package com.lp.interfaces.challenge;

import java.util.List;

import static com.lp.interfaces.challenge.Usage.*;
import static com.lp.interfaces.challenge.Utility.FIBER_OPTIC;
import static com.lp.interfaces.challenge.Utility.WATER;

public class MapApp {

    public static void main(String[] args) {
        List<Mappable> mappableList = List.of(
                new Building("Sydney Town Hall", GOVERNMENT),
                new Building("Sydney Opera House", ENTERTAINMENT),
                new Building("Stadium Australia", SPORT),
                new UtilityLine("College St", FIBER_OPTIC),
                new UtilityLine("Olympic Blvd", WATER));

        mappableList.forEach(Mappable::print);
    }
}
