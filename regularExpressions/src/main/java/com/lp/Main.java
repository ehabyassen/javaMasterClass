package com.lp;

public class Main {

    public static void main(String[] args) {
        String string = "I am a string. Yes I am.";
        System.out.println(string);
        String yourString = string.replaceAll("I", "You").replaceAll("am", "are");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(alphanumeric.replaceAll(".", "Y"));
        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));
        String secondString = "abcDeeeF12abcDeeeGhhiiiijkl99z";
        System.out.println(secondString.replaceAll("^abcDeee", "YYY"));

        System.out.println(alphanumeric.matches("^abcDeee"));
        System.out.println(alphanumeric.matches("abcDeeeF12Ghhiiiijkl99z"));
        System.out.println(alphanumeric.matches("^abcDeeeF12Ghhiiiijkl99z"));

        System.out.println("Ehab".replaceAll("hab$", "slam"));

        System.out.println("Ehab".replaceAll("[hb]", "n"));

        System.out.println("Anagram".replaceAll("[a][gm]", "X"));

        System.out.println("Harry".replaceAll("[Hh]arry", "Berry"));

        String newAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(newAlphanumeric.replaceAll("[^ej]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[abcdef345678]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[a-f3-8]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[a-fA-F3-8]", "X"));
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[0-9]", "X"));
        System.out.println(newAlphanumeric.replaceAll("\\d", "X"));
        System.out.println(newAlphanumeric.replaceAll("\\D", "X"));

        String hasWhiteSpace = "I have blank,\ta tab and also a new line\n";
        System.out.println(hasWhiteSpace);
        System.out.println(hasWhiteSpace.replaceAll("\\s", ""));
        System.out.println(hasWhiteSpace.replaceAll("\t", "X"));
        System.out.println(hasWhiteSpace.replaceAll("\\S", ""));


        System.out.println(newAlphanumeric.replaceAll("\\w", "X"));
        System.out.println(hasWhiteSpace.replaceAll("\\w", "X"));
        System.out.println(hasWhiteSpace.replaceAll("\\W", "X"));

        System.out.println(hasWhiteSpace.replaceAll("\\b", "X"));


    }
}
