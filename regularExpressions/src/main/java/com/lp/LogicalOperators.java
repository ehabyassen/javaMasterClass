package com.lp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogicalOperators {

    public static void main(String[] args) {
        // "abc" -> "a" and "b" and "c"
        // "[abc]" -> "a" or "b" or "c"
        System.out.println("harry".replaceAll("[H|h]", "L"));
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
        System.out.println("Harry".replaceAll("[H|h]arry", "Larry"));

        // [^abc] -> matches all except abc. ^ in [] means not
        // this can also be done using !
        String tvTest = "tstvtkt";
//        String notTVRegex = "t[^v]";
//        String notTVRegex = "t(?!v)"; //negative look ahead
        String notTVRegex = "t(?=v)"; //positive look ahead
        Pattern notTVPattern = Pattern.compile(notTVRegex);
        Matcher notTVMatcher = notTVPattern.matcher(tvTest);
        int count = 0;
        while (notTVMatcher.find()) {
            count++;
            System.out.println("Occurrence: " + count + " : " + notTVMatcher.start() + " to " + notTVMatcher.end());
        }

        String usNumberRegex = "^([\\(]{1}[0-9]{3}[\\)][ ][0-9]{3}[-]{1}[0-9]{4})$";
        Pattern usNumberPattern = Pattern.compile(usNumberRegex);
        Matcher matcher = usNumberPattern.matcher("(800) 123-4567");
        System.out.println(matcher.matches());
        matcher = usNumberPattern.matcher("8012345678");
        System.out.println(matcher.matches());

        System.out.println("=".repeat(50));

        String visa1 = "4444444444444";
        String visa2 = "5444444444444";
        String visa3 = "4444444444444444";
        String visa4 = "4444";
        String visaRegex = "^4[0-9]{12}([0-9]{3})?$";

        System.out.println(visa1.matches(visaRegex));
        System.out.println(visa2.matches(visaRegex));
        System.out.println(visa3.matches(visaRegex));
        System.out.println(visa4.matches(visaRegex));
    }
}
