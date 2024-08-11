package com.concurrencyJJ.threadOrder;

public class Demo {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            run();
        }
    }

    private static void run() {
        ValueExchanger valueExchanger = new ValueExchanger();

        Thread thread1 = new Thread(() -> {
            valueExchanger.setValue("Ehab");
            valueExchanger.setStarted();
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            while (!valueExchanger.isStarted()) {
                Thread.onSpinWait();
            }
            System.out.println(Thread.currentThread().getName() + ":: Value:" + valueExchanger.getValue());
        }, "Thread-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        System.out.println("+".repeat(30));
    }
}

class ValueExchanger {

    private String value;
    private volatile boolean started = false;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted() {
        this.started = true;
    }
}