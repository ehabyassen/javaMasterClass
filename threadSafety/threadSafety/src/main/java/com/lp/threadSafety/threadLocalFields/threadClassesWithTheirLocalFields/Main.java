package com.lp.threadSafety.threadLocalFields.threadClassesWithTheirLocalFields;

public class Main {

    public static void main(String[] args) {
        //each thread class has its own state and it is not shared with the other class
        //this makes them thread safe
        new ThreadA().start();
        new ThreadB().start();
    }
}
