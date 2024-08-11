package academy.learnprogramming.polymorphismChallenge;

import java.util.ArrayList;
import java.util.List;

public class CarApp {

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new GasPoweredCar(80, 6));
        cars.add(new ElectricCar(120, 300));
        cars.add(new HybridCar(100, 250, 8));

        for (Car c : cars) {
            System.out.println(c.getDescription());
            c.startEngine();
            c.drive();
            System.out.println("-".repeat(60));
        }
    }
}
