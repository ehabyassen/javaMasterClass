package com.lp.deadlock;

public class DeadLock2 {

    public static void main(String[] args) {
        PolitePesron ehab = new PolitePesron("Ehab");
        PolitePesron aya = new PolitePesron("Aya");

        new Thread(() -> ehab.sayHello(aya)).start();
        new Thread(() -> aya.sayHello(ehab)).start();
    }
}

class PolitePesron {
    private final String name;

    public PolitePesron(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public synchronized void sayHello(PolitePesron person) {
        System.out.format("%s: %s" + " has said hello to me!%n", person.getName(), this.name);
        person.sayHelloBack(this);
    }

    public synchronized void sayHelloBack(PolitePesron person) {
        System.out.format("%s: %s" + " has said hello back to me!%n", this.name, person.getName());
    }
}