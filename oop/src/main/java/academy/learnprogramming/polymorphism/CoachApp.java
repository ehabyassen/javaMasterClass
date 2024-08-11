package academy.learnprogramming.polymorphism;

import java.util.ArrayList;
import java.util.List;

public class CoachApp {

    public static void main(String[] args) {
        List<Coach> coaches = new ArrayList<>();
        coaches.add(new TennisCoach());
        coaches.add(new FootballCoach());

        for (Coach coach : coaches) {
            System.out.println("I am a " + coach.getSport() + " coach.");
        }

        var x = getCoach("Tiger");
        System.out.println(x.getSport());

        if (x instanceof TennisCoach tc) {

            System.out.println(tc.getSport());
        }

    }

    public static Coach getCoach(String name) {
        return switch (name.toLowerCase().charAt(0)) {
            case 'T', 'X' -> new TennisCoach();
            case 'F' ->  new FootballCoach();
            default -> new TennisCoach();
        };
    }
}
