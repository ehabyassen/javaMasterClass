package com.lambda;

import java.util.Comparator;

public class LambdaExample {

    public static void main(String[] args) {
        Comparator<String> stringComparator = String::compareTo;

        System.out.println(stringComparator.compare("hello", "world"));

        MyFunction myFunction = () -> System.out.println("MyFunction is called");

        myFunction.apply();
    }
}
