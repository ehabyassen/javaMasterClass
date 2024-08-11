package com.lp.optional.old;

public class Main {

    public static void main(String[] args) {
        //NPE is thrown
        System.out.println(new Computer().getSoundcard().getUsb().getVersion());

        //An ugly way to void that
        Computer computer = new Computer();
        if (computer != null) {
            SoundCard soundcard = computer.getSoundcard();
            if (soundcard != null) {
                Usb usb = soundcard.getUsb();
                if (usb != null) {
                    String version = usb.getVersion();
                    System.out.println(version);
                }
            }
        }
    }
}
