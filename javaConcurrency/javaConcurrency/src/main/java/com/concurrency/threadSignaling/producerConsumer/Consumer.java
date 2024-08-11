package com.concurrency.threadSignaling.producerConsumer;

public class Consumer implements Runnable {

    private final DataCarrier carrier;

    public Consumer(DataCarrier carrier) {
        this.carrier = carrier;
    }

    @Override
    public void run() {
        while (!carrier.isTransferStopped()) {
            while (!carrier.isDataProduced()) {
                Thread.onSpinWait();
            }
            System.out.println(Thread.currentThread().getName() + " Consumed: " + carrier.getData());
            carrier.setDataConsumed(true);
            carrier.setDataProduced(false);
        }
    }
}
