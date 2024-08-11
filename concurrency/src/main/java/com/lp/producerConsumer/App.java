package com.lp.producerConsumer;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.lp.producerConsumer.ThreadColor.*;

public class App {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);

        ReentrantLock bufferLock = new ReentrantLock(true);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.execute(new MyProducer(buffer, ANSI_BLUE));
        executorService.execute(new MyConsumer(buffer, ANSI_RED));
        executorService.execute(new MyConsumer(buffer, ANSI_GREEN));

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ANSI_PURPLE + "I am being printed for the Callable");
                return "This is the callable result.";
            }
        });

        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("Something went wrong");
        } catch (InterruptedException e) {
            System.out.println("Thread running the task was interrupted");
        }

        executorService.shutdown();
    }
}
