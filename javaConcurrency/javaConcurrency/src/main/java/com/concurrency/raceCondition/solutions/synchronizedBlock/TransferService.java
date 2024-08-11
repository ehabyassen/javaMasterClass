package com.concurrency.raceCondition.solutions.synchronizedBlock;

public class TransferService {

    private static final Object lock = new Object();

    public static void main(String[] args) {
        Account sourceAccount = new Account(500);
        Account destAccount = new Account(500);

        System.out.println(Thread.currentThread().getName() + ": Source account balance: " + sourceAccount.getBalance());
        System.out.println(Thread.currentThread().getName() + ": Dest account balance: " + destAccount.getBalance());
        System.out.println(Thread.currentThread().getName() + ":" + "-".repeat(50));

        Thread t1 = new Thread(() -> transfer(300, sourceAccount, destAccount));

        Thread t2 = new Thread(() -> {
            sleep();
            transfer(400, sourceAccount, destAccount);
        });

        t1.start();
        t2.start();
    }

    private static void transfer(int amount, Account sourceAccount, Account destAccount) {
        System.out.println(Thread.currentThread().getName() + ": started...");
        /*
            * synchronized block uses the intrinsic lock of the supplied instance to lock access to the
            specified block if a thread is currently executing that block.
            * using a static block can minimize that context of the locked part of code instead
              of locking an entire method / entire class's synchronized methods.
            * issues with using "this" with a synchronized block:
                - cannot be used from a static context "method"
                - can be hijacked from a context with an instance of the class because an attacker
                  can acquire the intrinsic lock of that instance and perform a DOS for that class
                  synchronized methods.
            * it is better to use a private reference of type Object and synchronized on its monitor lock
              this results in:
              * other synchronized methods in the same class can be simultaneously accessed by other threads.
              * DOS attack is not possible because the used lock is of a private field
              * that reference can be declared static to be used in a static context if required
            * avoid locking on String literal references because String literal reference with the same
              value points to the same reference. So, if another class locks on a String literal reference
              that has the same value in your class, deadlock can happen.
            * using the synchronized keyword does not guarantee fairness between scheduled threads that
              will execute the synchronized method/block and this can cause thread starvation if a thread
              is blocked for too long time.
            * also synchronized block is fully contained in a method.
            * Locks in java concurrent package provides better synchronization utils.
         */
//        synchronized (this) {
        synchronized (lock) {
            if (sourceAccount.getBalance() < amount) {
                System.out.println(Thread.currentThread().getName() + ": Source account does not have sufficient balance to transfer " + amount);
            } else {
                System.out.println(Thread.currentThread().getName() + ": checked source account balance.");
                sleep();
                destAccount.setBalance(destAccount.getBalance() + amount);
                sleep();
                System.out.println(Thread.currentThread().getName() + ": incremented dest account.");
                sleep();
                sourceAccount.setBalance(sourceAccount.getBalance() - amount);
                sleep();
                System.out.println(Thread.currentThread().getName() + ": decremented source account.");
                sleep();
                System.out.println(Thread.currentThread().getName() + ": Transferred [" + amount + "] from sourceAccount to destAccount.");
            }
        }
        System.out.println(Thread.currentThread().getName() + ": Source account balance: " + sourceAccount.getBalance());
        System.out.println(Thread.currentThread().getName() + ": Dest account balance: " + destAccount.getBalance());
        System.out.println(Thread.currentThread().getName() + ":" + "-".repeat(50));
        System.out.println(Thread.currentThread().getName() + ": finished...");
    }

    private static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            //ignore e
        }
    }
}
