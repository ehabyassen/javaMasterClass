package com.lp.optional.old.refactored;

public class Usb {

    private String version;

    public Usb(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Usb{" +
                "version='" + version + '\'' +
                '}';
    }
}
