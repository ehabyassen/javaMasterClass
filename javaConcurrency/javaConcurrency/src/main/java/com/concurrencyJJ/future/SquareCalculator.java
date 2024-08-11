package com.concurrencyJJ.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareCalculator {

    private final ExecutorService service;

    public SquareCalculator(ExecutorService service) {
        this.service = service;
    }

    public Future<Integer> calculate(int number) {
        return service.submit(() -> {
            int x = 0;
            for (int i = 0; i <2_000_000_000; i++) {
                x++;
            }
            System.out.println(x);
            return number * number;
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        SquareCalculator calculator = new SquareCalculator(service);
        Future<Integer> result = calculator.calculate(4);

        Thread.sleep(10);

        boolean cancelled = result.cancel(false);
        System.out.println(cancelled);
        System.out.println(result.get());

        service.shutdown();
    }
}
