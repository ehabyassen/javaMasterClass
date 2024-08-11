package com.lp.serialisation;

import java.io.Serializable;
import java.util.Optional;

public class Sock implements Serializable {

    String type;
    Optional<Integer> size;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Optional<Integer> getSize() {
        return size;
    }

    public void setSize(Optional<Integer> size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Sock{" +
                "type='" + type + '\'' +
                ", size=" + size +
                '}';
    }
}
