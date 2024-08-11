package academy.learnprogramming.oopChallenge;

import java.util.ArrayList;
import java.util.List;

public class Burger {

    public enum TYPE {Classic, Cheese, Hamburger, Chilli, Deluxe}

    public enum SIZE {l, xl, xxl}

    public enum TOPPING {garlic, catchup, mustard}

    private TYPE type;
    private SIZE size;
    private double priceInUsd;
    private List<TOPPING> toppings;

    public Burger() {
        this.type = TYPE.Classic;
        this.size = SIZE.l;
        this.priceInUsd = 8;
        this.toppings = new ArrayList<>();
    }

    public Burger(TYPE type, SIZE size) {
        this.type = (type == null) ? TYPE.Classic : type;
        this.size = (size == null) ? SIZE.l : size;
        this.priceInUsd = calculateBurgerPrice();
        this.toppings = new ArrayList<>();
    }

    public double getPriceInUsd() {
        return priceInUsd;
    }

    public TYPE getType() {
        return type;
    }

    public SIZE getSize() {
        return size;
    }

    public List<TOPPING> getToppings() {
        return toppings;
    }

    public void addTopping(TOPPING topping) {
        if (this.type == TYPE.Deluxe) {
            if (toppings.size() < 5) {
                toppings.add(topping);
                System.out.println("Added a topping of type " + topping.name() + ". Price is: " + getPriceInUsd());
            } else {
                System.out.println("Cannot add a topping. You can add only up to 5 toppings.");
            }
        } else {
            if (toppings.size() < 3) {
                toppings.add(topping);
                priceInUsd += switch (topping) {
                    case garlic -> 0.8;
                    case catchup -> 1;
                    case mustard -> 1.25;
                };
                System.out.println("Added a topping of type " + topping.name() + ". Price is: " + getPriceInUsd());
            } else {
                System.out.println("Cannot add a topping. You can add only up to 3 toppings.");
            }
        }
    }

    private double calculateBurgerPrice() {
        double price = 0;
        price += switch (type) {
            case Classic -> 8;
            case Cheese -> 9;
            case Hamburger -> 10;
            case Chilli -> 11;
            case Deluxe -> 12;
        };
        price += switch (size) {
            case l -> 2;
            case xl -> 3.5;
            case xxl -> 5.75;
        };
        return price;
    }
}
