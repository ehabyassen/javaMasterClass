package com.concurrencyJJ.locks.reentrantLock;

import java.util.concurrent.locks.Lock;

public abstract class Calculation {

    protected long value;

    public Calculation(long value) {
        this.value = value;
    }

    abstract long execute(Lock lock, long operand);
}
