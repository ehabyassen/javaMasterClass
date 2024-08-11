package com.example.collections.set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class Main {

    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {


        HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Venus",  23);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        HeavenlyBody moon = new HeavenlyBody("Moon", 27);
        solarSystem.put(moon.getName(), moon);
        temp.addSatellite(moon);

        temp = new HeavenlyBody("Jupiter", 888);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        HeavenlyBody io = new HeavenlyBody("Io", 123);
        HeavenlyBody ganymedo = new HeavenlyBody("Ganymedo", 35);
        HeavenlyBody callisto = new HeavenlyBody("Callisto", 45);
        HeavenlyBody europa = new HeavenlyBody("Europa", 78);
        solarSystem.put(io.getName(), io);
        solarSystem.put(ganymedo.getName(), ganymedo);
        solarSystem.put(callisto.getName(), callisto);
        solarSystem.put(europa.getName(), europa);
        temp.addSatellite(io);
        temp.addSatellite(ganymedo);
        temp.addSatellite(callisto);
        temp.addSatellite(europa);

        temp = new HeavenlyBody("Mars", 686465);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        HeavenlyBody deimos = new HeavenlyBody("Deimos", 123);
        HeavenlyBody phobos = new HeavenlyBody("Phobos", 35);
        solarSystem.put(deimos.getName(), deimos);
        solarSystem.put(phobos.getName(), phobos);
        temp.addSatellite(deimos);
        temp.addSatellite(phobos);

        temp = new HeavenlyBody("Saturn", 10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Uranus", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Neptune", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Pluto", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        System.out.println("Planets:");
        planets.forEach(p -> System.out.println("\t" + p.getName()));

        System.out.println("Earth Moons:");
        solarSystem.get("Earth").getSatellites().forEach(m -> System.out.println("\t" + m.getName()));

        System.out.println("Moons:");
        Set<HeavenlyBody> moons = planets.stream()
                .flatMap(p -> p.getSatellites().stream())
                .collect(toSet());
        moons.forEach(m -> System.out.println("\t" + m.getName()));

        System.out.println("-".repeat(30));

        HeavenlyBody pluto = new HeavenlyBody("Pluto", 842);
        planets.add(pluto);
        System.out.println(planets);


    }
}
