package com.lp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Quantifiers {

    public static void main(String[] args) {
        String alphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));
        System.out.println(alphanumeric.replaceAll("^abcDe{3}", "YYY"));
        System.out.println(alphanumeric.replaceAll("^abcDe+", "YYY"));
        System.out.println(alphanumeric.replaceAll("^abcDe*", "YYY"));
        System.out.println(alphanumeric.replaceAll("^abcDe{2,5}", "YYY"));
        System.out.println(alphanumeric.replaceAll("h+i*j", "YYY"));
        System.out.println("=".repeat(50));

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");
        htmlText.append("<h2></h2>");

        System.out.println(htmlText);
        System.out.println("=".repeat(50));

        String h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("Occurrence: " + count + " : " + matcher.start() + " to " + matcher.end());
        }

        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while (groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextGroupsPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextGroupsPattern.matcher(htmlText);
        System.out.println(h2TextMatcher.matches());
        h2TextMatcher.reset();

        while (h2TextMatcher.find()) {
            System.out.println("Occurrence: " + h2TextMatcher.group(2));
        }
    }
}
