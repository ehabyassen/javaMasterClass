package com.lp.livelock;

public class Main {

    /**
     * In livelock, threads keep sharing common resources without doing any useful work.
     * @param args
     */

    public static void main(String[] args) {
        final Worker worker1 = new Worker("Worker 1", true);
        final Worker worker2 = new Worker("Worker 2", true);

        final SharedResource sharedResource = new SharedResource(worker1);

        new Thread(() -> worker1.work(sharedResource, worker2)).start();
        new Thread(() -> worker2.work(sharedResource, worker1)).start();
    }

}

class Worker {

    private final String name;
    private boolean active;

    public Worker(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public synchronized void work(SharedResource sharedResource, Worker otherWorker) {
        while (active) {
            if (sharedResource.getOwner() != this) {
                try {
                    wait(100);
                } catch (InterruptedException e) {
                }
                continue;
            }

            if (otherWorker.isActive()) {
                System.out.println(getName() + ": give the resource to the worker " + otherWorker.getName());
                sharedResource.setOwner(otherWorker);
                continue;
            }

            System.out.println(getName() + ": working on the common resource");
            active = false;
            sharedResource.setOwner(otherWorker);
        }
    }
}

class SharedResource {

    private Worker owner;

    public SharedResource(Worker owner) {
        this.owner = owner;
    }

    public Worker getOwner() {
        return owner;
    }

    public synchronized void setOwner(Worker owner) {
        this.owner = owner;
    }
}