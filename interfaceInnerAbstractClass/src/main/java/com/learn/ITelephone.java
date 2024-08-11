package com.learn;

public interface ITelephone {

    public void powerOn();
    public void callPhone(String phoneNumber);
    public void answer();
    public boolean isRinging();

    default void test() {
        System.out.println("default method implementation");
    }
}
