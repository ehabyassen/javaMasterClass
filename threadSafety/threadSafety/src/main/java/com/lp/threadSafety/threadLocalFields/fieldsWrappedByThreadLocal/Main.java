package com.lp.threadSafety.threadLocalFields.fieldsWrappedByThreadLocal;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                StateHolder state = ThreadState.getState();
                System.out.println(state);
            }).start();
        }
    }
}
