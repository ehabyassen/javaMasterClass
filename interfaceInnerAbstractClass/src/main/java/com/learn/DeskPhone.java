package com.learn;

public class DeskPhone implements ITelephone {

    private String phoneNumber;
    private boolean isRinging;

    public DeskPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void powerOn() {
        System.out.println("Starting the phone...");
    }

    @Override
    public void callPhone(String phoneNumber) {
        if (phoneNumber.equals(this.phoneNumber)) {
            isRinging = true;
        } else {
            isRinging = false;
        }
    }

    @Override
    public void answer() {
        System.out.println("Answering a call...");
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
