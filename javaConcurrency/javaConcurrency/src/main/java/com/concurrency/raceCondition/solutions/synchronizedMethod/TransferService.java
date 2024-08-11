
package com.concurrency.raceCondition.solutions.synchronizedMethod;

public class TransferService {

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

    /*
    * when the synchronized keyword used in a method signature, the first thread that calls the method
    * will acquire the monitor/intrinsic lock of the instance and this will cause the following:
        - any other threads that calls the method will have to wait until the current executing thread
          is done with the method and releases the lock then one of the waiting threads can acquire it
          and start execution.
        - the entire method body is locked.
        - any other synchronized method will be locked for the same instance because the monitor lock
          belongs to the instance.
        - any other non-synchronized methods will not be locked and therefore can be called by other threads
         on the same instance.
     * this level of synchronization can be relaxed or done on a tighter context using synchronized blocks
     */
    private static synchronized void transfer(int amount, Account sourceAccount, Account destAccount) {
        System.out.println(Thread.currentThread().getName() + ": started...");
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
