package com.learn;

public class PhoneApp {

    public static void main(String[] args) {
        ITelephone p1 = new DeskPhone("012345");
        p1.powerOn();
        p1.callPhone("012345");
        p1.answer();
        p1.test();
    }
}
