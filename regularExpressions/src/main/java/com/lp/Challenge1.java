package com.lp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge1 {

    public static void main(String[] args) {
        String challenge1 = "I want a bike.";
        System.out.println(challenge1.matches("I want a bike."));

        String challenge2 = "I want a ball.";

        String regex2 = "^I want a \\w+.";
        String regex22 = "^I want a \\w+.";

        System.out.println(challenge1.matches(regex2));
        System.out.println(challenge2.matches(regex2));
        System.out.println(challenge1.matches(regex22));
        System.out.println(challenge2.matches(regex22));

        Pattern pattern2 = Pattern.compile(regex2);
        System.out.println(pattern2.matcher(challenge1).matches());
        System.out.println(pattern2.matcher(challenge2).matches());

        String challenge4 = "Replace all blanks with underscores.";
        System.out.println(challenge4.replaceAll("\\s", "_"));

        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5.matches("[a-g]+"));
        System.out.println(challenge5.matches("^a{3}bc{8}d{3}ef{3}g"));
        System.out.println(challenge5.replaceAll("^a{3}bc{8}d{3}ef{3}g", "REPLACED"));

        String challenge7 = "abcd.135";
        System.out.println(challenge7.matches("^\\D+\\.\\d+$"));


        String challenge8 = "abcd.135uvqz.7tzik.999";
        Pattern pattern8 = Pattern.compile("[a-zA-Z]+\\.(\\d+)");
        Matcher matcher8 = pattern8.matcher(challenge8);
        int count8 = 0;
        while (matcher8.find()) {
            count8++;
            System.out.println("Occurrence: " + count8 + " -> " + matcher8.group(1) + " start: " + matcher8.start() + " end: " + matcher8.end());
        }

        System.out.println("=".repeat(50));

        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
        Pattern pattern9 = Pattern.compile("[a-zA-Z]+\\.(\\d+)");
        Matcher matcher9 = pattern9.matcher(challenge9);
        int count9 = 0;
        while (matcher9.find()) {
            count9++;
            System.out.println("Occurrence: " + count9 + " -> " + matcher9.group(1) + " start: " + matcher9.start(1) + " end: " + (matcher9.end(1) - 1));
        }

        System.out.println("=".repeat(50));

        String challenge10 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
        Pattern pattern10 = Pattern.compile("\\{(.+?)\\}");
        Matcher matcher10 = pattern10.matcher(challenge10);
        while (matcher10.find()) {
            System.out.println(matcher10.group(1));
        }

        System.out.println("=".repeat(50));

        String challenge10a = "{0, 2}, {0, 5}, {1, 3}, {2, 4}, {x, y}, {2, 4}, {11, 12}";
        Pattern pattern10a = Pattern.compile("\\{(\\d+, \\d+)\\}");
        Matcher matcher10a = pattern10a.matcher(challenge10a);
        while (matcher10a.find()) {
            System.out.println(matcher10a.group(1));
        }

        System.out.println("=".repeat(50));

        String challenge12 = "11111";
        System.out.println(challenge12.matches("^\\d{5}$"));

        System.out.println("=".repeat(50));

        String challenge13 = "11111-1111";
        System.out.println(challenge13.matches("^\\d{5}-\\d{4}$"));

        System.out.println("=".repeat(50));
        String challenge14 = "11111";
        String challenge14a = "11111-1111";
        System.out.println(challenge14.matches("^\\d{5}(-\\d{4})?$"));
        System.out.println(challenge14a.matches("^\\d{5}(-\\d{4})?$"));

        
    }
}
