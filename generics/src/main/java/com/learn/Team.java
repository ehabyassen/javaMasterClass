package com.learn;

import java.util.ArrayList;
import java.util.List;

public class Team<T extends Player> implements Comparable<Team<T>> {

    private final String name;
    private final List<T> players = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(T player) {
        if (players.stream().noneMatch(p -> p.getName().equals(player.getName()))) {
            players.add(player);
        }
    }

    public int getTeamSize() {
        return players.size();
    }

    @Override
    public int compareTo(Team<T> tTeam) {
        return this.name.compareTo(tTeam.getName());
    }
}
