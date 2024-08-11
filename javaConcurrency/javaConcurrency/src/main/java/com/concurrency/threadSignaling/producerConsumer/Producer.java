package com.concurrency.threadSignaling.producerConsumer;

import java.util.List;

public class Producer implements Runnable {

    private final DataCarrier carrier;

    private static final List<String> DATA = List.of("One", "Two", "Three", "Four", "Five", "Six");

    public Producer(DataCarrier carrier) {
        this.carrier = carrier;
    }

    @Override
    public void run() {
        DATA.forEach(element -> {
            carrier.setData(element);
            System.out.println(Thread.currentThread().getName() + " Produced: " + carrier.getData());
            if (DATA.indexOf(element) == DATA.size() - 1) {
                carrier.stopTransfer();
            }
            carrier.setDataProduced(true);
            while (!carrier.isDataConsumed()) {
                Thread.onSpinWait();
            }
            carrier.setDataConsumed(false);
        });
    }
}
