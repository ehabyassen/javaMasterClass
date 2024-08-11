package com.learn.league;

public class LeagueApp {

    public static void main(String[] args) {
        TennisTeam tt1 = new TennisTeam("Tennis team1", 4);
        TennisTeam tt2 = new TennisTeam("Tennis team2", 1);
        TennisTeam tt3 = new TennisTeam("Tennis team3", 3);
        TennisTeam tt4 = new TennisTeam("Tennis team4", 2);

        FootballTeam ft1 = new FootballTeam("Football team 1", 2);
        FootballTeam ft2 = new FootballTeam("Football team 2", 3);
        FootballTeam ft3 = new FootballTeam("Football team 3", 1);

        League<TennisTeam> tennisLeague = new League<>("League Tennis");
        League<FootballTeam> premierLeague = new League<>("Premier League");

        tennisLeague.addTeam(tt1);
        tennisLeague.addTeam(tt2);
        tennisLeague.addTeam(tt3);
        tennisLeague.addTeam(tt4);
        //tennisLeague.addTeam(ft1);

        premierLeague.addTeam(ft1);
        premierLeague.addTeam(ft2);
        premierLeague.addTeam(ft3);
        //premierLeague.addTeam(tt4);

        tennisLeague.printTable();
        System.out.println("-".repeat(30));
        premierLeague.printTable();
    }
}
