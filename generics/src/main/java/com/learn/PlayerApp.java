package com.learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerApp {

    public static void main(String[] args) {
        FootballPlayer ehab = new FootballPlayer("Ehab");
        TennisPlayer aya = new TennisPlayer("Aya");
        BaseballPlayer mike = new BaseballPlayer("Mike");

        Team<FootballPlayer> footballTeam = new Team<>("Team1");
        footballTeam.addPlayer(ehab);

        Team<BaseballPlayer> baseballTeam = new Team<>("Team2");
        baseballTeam.addPlayer(mike);

        List<Team> teams = new ArrayList<>();
        Collections.sort(teams);
    }
}
