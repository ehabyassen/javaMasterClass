package com.concurrency.threadSignaling.producerConsumer;

public class DataCarrier {

    private String data;
    private volatile boolean dataProduced;
    private boolean dataConsumed;
    private boolean transferStopped;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isDataProduced() {
        return dataProduced;
    }

    public void setDataProduced(boolean dataProduced) {
        this.dataProduced = dataProduced;
    }

    public boolean isDataConsumed() {
        return dataConsumed;
    }

    public void setDataConsumed(boolean dataConsumed) {
        this.dataConsumed = dataConsumed;
    }

    public boolean isTransferStopped() {
        return transferStopped;
    }

    public void stopTransfer() {
        transferStopped = true;
    }
}
