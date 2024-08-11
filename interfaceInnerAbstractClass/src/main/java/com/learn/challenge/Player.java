package com.learn.challenge;

import java.util.ArrayList;
import java.util.List;

public class Player implements Saveable {

    private String name;
    private int hitPoints;
    private int strength;
    private String weapon;

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                '}';
    }

    @Override
    public List<String> write() {
        List<String> data = new ArrayList<>();
        data.add(0, name);
        data.add(1, String.valueOf(hitPoints));
        data.add(2, String.valueOf(strength));
        data.add(3, weapon);
        return data;
    }

    @Override
    public void read(List<String> data) {
        if (data != null && !data.isEmpty()) {
            name = data.get(0);
            hitPoints = Integer.parseInt(data.get(1));
            strength = Integer.parseInt(data.get(2));
            weapon = data.get(3);
        }
    }
}
