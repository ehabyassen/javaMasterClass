package com.concurrencyJJ.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class FactorialSquareCalculator extends RecursiveTask<Integer> {

    private final int n;

    public FactorialSquareCalculator(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return 1;
        }

        FactorialSquareCalculator calculator = new FactorialSquareCalculator(n - 1);

        calculator.fork();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return n * n + calculator.join();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FactorialSquareCalculator calculator = new FactorialSquareCalculator(4);
        ForkJoinTask<Integer> result = forkJoinPool.submit(calculator);
        System.out.println(result.get());
    }
}
