package com.learn.challenge;

import java.util.List;

public interface Saveable {

    List<String> write();
    void read(List<String> data);
}
