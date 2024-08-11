package com.learn.challenge;

import java.util.List;

public class App {

    public static void main(String[] args) {
        Saveable obj = loadObj(new Player());
        saveObject(obj);
    }

    public static void saveObject(Saveable obj) {
        for (String data : obj.write()) {
            System.out.println("Saving " + data + " to storage.");
        }
    }

    public static Saveable loadObj(Saveable obj) {
        List<String> data = readValues();
        obj.read(data);
        return obj;
    }

    private static List<String> readValues() {
        return List.of("Ehab", "999", "100", "AKM");
    }
}
