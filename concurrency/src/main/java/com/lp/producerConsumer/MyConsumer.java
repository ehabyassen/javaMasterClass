package com.lp.producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;

import static com.lp.producerConsumer.App.EOF;

public class MyConsumer implements Runnable {

    private final ArrayBlockingQueue<String> buffer;
    private final String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {
                }

            }
        }
    }
}
