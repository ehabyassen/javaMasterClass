package com.concurrencyJJ.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareCalculator2 {

    private final ExecutorService service;

    public SquareCalculator2(ExecutorService service) {
        this.service = service;
    }

    public Future<Integer> calculate(int number) {
        return service.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " is calculating for " + number);
            Thread.sleep(1000);
            return number * number;
        });
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        SquareCalculator2 calculator = new SquareCalculator2(service);

        Future<Integer> future1 = calculator.calculate(10);
        Future<Integer> future2 = calculator.calculate(100);

        while (!(future1.isDone() && future2.isDone())) {
            Thread.sleep(300);
            System.out.format("Future1 is %s and Future2 is %s%n",
                    future1.isDone() ? "done" : "not done",
                    future2.isDone() ? "done" : "not done");
        }

        Integer result1 = future1.get();
        Integer result2 = future2.get();

        System.out.println(result1 + " and " + result2);

        service.shutdown();
    }
}
