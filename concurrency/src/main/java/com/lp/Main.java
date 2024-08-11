package com.lp;

import static com.lp.ThreadColor.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(ANSI_PURPLE + "Hello from the main thread!");

        AnotherThread anotherThread = new AnotherThread();
        anotherThread.setName("==Another Thread==");
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from the anonymous class!");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anon class's impementation of MyRunnable's run()");

                try {
                    anotherThread.join();
                    System.out.println(ANSI_RED + "Another thread terminated, so i am running again");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "I could not wait after all. I was interrupted.");
                }

            }
        });
        myRunnableThread.start();


        System.out.println(ANSI_PURPLE + "Hello again from the main thread!!");

    }
}
