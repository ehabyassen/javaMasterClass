package com.concurrencyJJ.locks.reentrantLock;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Calculator {

    private long result = 0;
    private final Lock lock = new ReentrantLock();

    public void calculate(List<Calculation> calculations) {
        try {
            lock.lock();
            calculations.forEach(calculation -> {
                result = calculation.execute(lock, result);
            });
        } finally {
            lock.unlock();
        }
    }

    public long getResult() {
        return result;
    }
}
