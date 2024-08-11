package com.lp.challenge;

import static java.util.Comparator.naturalOrder;

public class Main {

    public static void main(String[] args) {
        QueryList<LPAStudent> students = new QueryList<>();
        for (int i = 1; i <= 25; i++) {
            students.add(new LPAStudent());
        }

        System.out.println("Ordered:");
        students.sort(naturalOrder());
        students.forEach(System.out::println);

        System.out.println();

        System.out.println("Matches:");
        QueryList<LPAStudent> matches = students.getMatches("percentComplete", "50")
                        .getMatches("course", "Python");
        matches.forEach(System.out::println);

        System.out.println();

        matches.sort(LPAStudent.compareByPercentComplete());
        matches.forEach(System.out::println);

        System.out.println();

        matches.sort(null);
        matches.forEach(System.out::println);
    }
}
