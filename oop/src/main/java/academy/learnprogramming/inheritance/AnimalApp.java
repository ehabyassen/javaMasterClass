package academy.learnprogramming.inheritance;

public class AnimalApp {

    public static void main(String[] args) {
        Animal animal = new Animal("Animal", 1, 1, 5, 5);

        Dog dog = new Dog("Jio", 5, 5, 2, 4, 1, 16, "long");
        dog.eat();
    }
}
