package com.concurrencyJJ.deadlock;

public class DeadLockExample1 {

    public static void main(String[] args) {
        Foo foo = new Foo();
        Bar bar = new Bar();

        Thread t1 = new Thread(() -> foo.doFoo(bar));
        Thread t2 = new Thread(() -> bar.doBar(foo));

        t1.start();
        t2.start();
    }
}

class Foo {

    synchronized void doFoo(Bar bar) {
        System.out.println(Thread.currentThread().getName() + " Foo...");
        bar.doBar(this);
    }
}

class Bar {

    synchronized void doBar(Foo foo) {
        System.out.println(Thread.currentThread().getName() + " Bar...");
        foo.doFoo(this);
    }
}