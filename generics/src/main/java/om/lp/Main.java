package om.lp;

interface Player {

    String name();
}

record BaseballPlayer(String name, String position) implements Player {
}

record FootballPlayer(String name, String position) implements Player {
}

record VolleyPlayer(String name, String position) implements Player {

}

public class Main {

    public static void main(String[] args) {
        Affiliation affiliation = new Affiliation("city", "PA", "US");
        Team<FootballPlayer, Affiliation> footballTeam = new Team<>("al ahly");
        footballTeam.addMember(new FootballPlayer("abo trika", "mid fielder"));
        footballTeam.addMember(new FootballPlayer("vlavio", "striker"));
//        footballTeam.addMember(new BaseballPlayer("Ali Alokka", "Striker"));
        footballTeam.listMembers();


        Team<VolleyPlayer, Affiliation> adelide = new Team<>("Adelide", affiliation);
        adelide.addMember(new VolleyPlayer("N Roberts", "Setter"));
        adelide.listMembers();

        Team<VolleyPlayer, String> canberra = new Team<>("Canberra", "city of canberra, SA, AU");
        canberra.addMember(new VolleyPlayer("B Blacks", "Opposite"));
        canberra.listMembers();


    }

    private static void scoreResult(Team t1, int t1Score, Team t2, int t2Score) {
        String matchScore = t1.setScore(t1Score, t2Score);
        t2.setScore(t2Score, t1Score);
        System.out.printf("%s %s %s %n", t1, matchScore, t2);
    }
}
