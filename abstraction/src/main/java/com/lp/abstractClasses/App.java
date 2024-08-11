package com.lp.abstractClasses;

import java.util.List;

public class App {

    public static void main(String[] args) {
//        Animal animal = new Animal("animal", "big", 100);
        Dog dog = new Dog("Wolf", "big", 100);
        dog.makeNoise();
        doAnimalStuff(dog);

        System.out.println("=".repeat(50));

        List<Animal> animals = List.of(
                dog,
                new Dog("German Shepard", "big", 150),
                new Fish("Goldfish", "small", 1),
                new Fish("Barracuda", "big", 75),
                new Dog("Pug", "small", 20),
                new Horse("Clydesdale", "large", 1000));

        animals.forEach(App::doAnimalStuff);
    }

    private static void doAnimalStuff(Animal animal) {
        animal.makeNoise();
        animal.move("slow");

        if (animal instanceof Mammal mammal) {
            mammal.shedHair();
        }
    }
}
