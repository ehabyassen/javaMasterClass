package com.learn.league;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class League<T extends Team> {

    private String name;

    private List<T> table;

    public League(String name) {
        this.name = name;
        this.table = new ArrayList<>();
    }

    public void addTeam(T team) {
        table.add(team);
    }

    public void printTable() {
        String tableToStr = table.stream()
                .sorted()
                .map(Team::toString)
                .collect(Collectors.joining("\n\t", "[\n\t", "\n]"));
        System.out.println(tableToStr);
    }
}
