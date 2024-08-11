package com.lp.customSerialization;

public record Address(int houseNumber) {

    @Override
    public String toString() {
        return "Address{" + "houseNumber=" + houseNumber + '}';
    }
}
