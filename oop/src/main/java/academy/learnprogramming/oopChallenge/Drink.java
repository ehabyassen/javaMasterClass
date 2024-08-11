package academy.learnprogramming.oopChallenge;

public class Drink {

    public enum SIZE {s, m, l}

    private String type;
    private SIZE size;
    private double priceInUsd;

    public Drink() {
        type = "Coke";
        size = SIZE.s;
        priceInUsd = 2;
    }

    public Drink(String type, SIZE size) {
        this.type = type;
        this.size = (size == null) ? SIZE.s : size;
        this.priceInUsd = calculateDrinkPrice();
    }

    public double getPriceInUsd() {
        return priceInUsd;
    }

    public String getType() {
        return type;
    }

    public SIZE getSize() {
        return size;
    }

    public void setSize(SIZE size) {
        this.size = size;
        this.priceInUsd = calculateDrinkPrice();
    }

    private double calculateDrinkPrice() {
        return switch (size) {
            case s -> 2;
            case m -> 3;
            case l -> 4.5;
        };
    }
}
