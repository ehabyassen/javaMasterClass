package om.lp;

import java.util.ArrayList;
import java.util.List;

public class BaseballTeam {

    private String teamName;
    private List<BaseballPlayer> members = new ArrayList<>();
    private int wins = 0;
    private int loses = 0;
    private int ties = 0;

    public BaseballTeam(String teamName) {
        this.teamName = teamName;
    }

    public void addMember(BaseballPlayer player) {
        if (!members.contains(player)) members.add(player);
    }

    public void listMembers() {
        System.out.println(teamName + " roster: ");
        System.out.println(members);
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
