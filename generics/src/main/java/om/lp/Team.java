package om.lp;

import java.util.ArrayList;
import java.util.List;

record Affiliation(String name, String type, String countryCode) {
    @Override
    public String toString() {
        return name + " (" + type + " in " + countryCode + ")";
    }
}

public class Team<T extends Player, S> {

    private final String teamName;
    private final List<T> members = new ArrayList<>();
    private int wins = 0;
    private int loses = 0;
    private int ties = 0;

    private S affiliation;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(String teamName, S affiliation) {
        this.teamName = teamName;
        this.affiliation = affiliation;
    }

    public void addMember(T player) {
        if (!members.contains(player)) members.add(player);
    }

    public void listMembers() {
        System.out.println(teamName + " roster: ");
        System.out.println(affiliation == null ? "" : "AFFILIATION: " + affiliation);
        for (T member : members) {
            System.out.println(member.name());
        }
    }

    public int ranking() {
        return (loses * 2) + ties + 1;
    }

    public String setScore(int ourScore, int theirScore) {
        if (ourScore > theirScore) {
            wins++;
            return "beat";
        } else if (ourScore < theirScore) {
            loses++;
            return  "lost to";
        } else {
            ties++;
            return "tied";
        }
    }

    @Override
    public String toString() {
        return teamName + " (Ranked " + ranking() + ")";
    }
}
