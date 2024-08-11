package academy.learnprogramming.oopChallenge;

public class SideItem {

    public enum TYPE {Fries, IceCream, OnionRings}

    private final TYPE type;
    private final double priceInUsd;

    public SideItem() {
        this.type = TYPE.Fries;
        this.priceInUsd = calculateItemPrice();
    }

    public SideItem(TYPE type) {
        this.type = (type == null) ? TYPE.Fries : type;
        this.priceInUsd = calculateItemPrice();
    }

    public double getPriceInUsd() {
        return priceInUsd;
    }

    public TYPE getType() {
        return type;
    }

    private double calculateItemPrice() {
        return switch (type) {
            case Fries -> 1.5;
            case IceCream -> 2;
            case OnionRings -> 2.5;
        };
    }
}