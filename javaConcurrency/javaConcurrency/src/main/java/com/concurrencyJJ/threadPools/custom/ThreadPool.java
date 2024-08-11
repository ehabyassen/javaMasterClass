package com.concurrencyJJ.threadPools.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {

    private final BlockingQueue<Runnable> taskQueue;
    private final List<ThreadPoolRunnable> runnables = new ArrayList<>();
    private boolean isStopped;

    public ThreadPool(int numOfThreads, int maxNumOfTasks) {
        taskQueue = new ArrayBlockingQueue<>(maxNumOfTasks);
        for (int i = 0; i < numOfThreads; i++) {
            ThreadPoolRunnable runnable = new ThreadPoolRunnable(taskQueue);
            runnables.add(runnable);
        }
        runnables.forEach(runnable -> new Thread(runnable).start());
    }

    public synchronized void execute(Runnable task) {
        if (isStopped) throw new IllegalStateException("ThreadPool is stopped!");
        taskQueue.offer(task);
    }

    public synchronized void stop() {
        isStopped = true;
        runnables.forEach(ThreadPoolRunnable::doStop);
    }

    public synchronized void waitUntilAllTasksAreFinished() {
        while (!taskQueue.isEmpty()) {
            Thread.onSpinWait();
        }
    }
}
