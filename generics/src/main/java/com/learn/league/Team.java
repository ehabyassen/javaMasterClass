package com.learn.league;

public class Team implements Comparable<Team> {

    private String name;
    private int rank;

    public Team(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public int compareTo(Team team) {
        return Integer.compare(this.rank, team.getRank());
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", rank=" + rank +
                '}';
    }
}
