package com.lp.threadSafety.threadLocalFields.fieldsWrappedByThreadLocal;

public class StateHolder {

    private String state;

    public StateHolder(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
