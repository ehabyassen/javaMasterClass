package com.concurrencyJJ.threadPools.custom;

public class Demo {

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(3, 10);

        for (int i = 0; i < 10; i++) {
            int taskNum = i;
            threadPool.execute(() -> {
                try {
                    Thread.sleep((long) (Math.random() * 100));
                } catch (InterruptedException e) {
                    //keep it alive
                }
                System.out.println(Thread.currentThread().getName() + ": Task_" + taskNum);
            });
        }

        threadPool.waitUntilAllTasksAreFinished();
        threadPool.stop();
    }
}
