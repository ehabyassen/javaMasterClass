package com.concurrencyJJ.locks.reentrantLock;

import java.util.concurrent.locks.Lock;

public class Subtraction extends Calculation {

    public Subtraction(long value) {
        super(value);
    }

    @Override
    long execute(Lock lock, long operand) {
        try {
            lock.lock();
            return operand - value;
        } finally {
            lock.unlock();
        }
    }
}
