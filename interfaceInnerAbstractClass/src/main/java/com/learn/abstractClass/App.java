package com.learn.abstractClass;

public class App {

    public static void main(String[] args) {
        Animal fish = new Fish("lory");
        fish.eat();
        fish.breath();

        Pidgen bird = new Pidgen("Parrot");
        bird.eat();
        bird.breath();
        bird.fly();

        Penguin lily = new Penguin("Lily");
        lily.eat();
    }
}
