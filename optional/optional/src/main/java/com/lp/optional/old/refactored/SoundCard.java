package com.lp.optional.old.refactored;

import java.util.Optional;

public class SoundCard {

    private String name;
    private Optional<Usb> usb;

    public SoundCard(String name) {
        this.name = name;
    }

    public Optional<Usb> getUsb() {
        return usb;
    }

    public void setUsb(Usb usb) {
        this.usb = Optional.of(usb);
    }

    @Override
    public String toString() {
        return "SoundCard{" +
                "name='" + name + '\'' +
                '}';
    }
}
