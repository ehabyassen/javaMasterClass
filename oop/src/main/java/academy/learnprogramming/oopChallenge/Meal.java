package academy.learnprogramming.oopChallenge;

import static java.util.stream.Collectors.joining;

public class Meal {

    private Burger burger;
    private Drink drink;
    private SideItem sideItem;

    public Meal() {
        this.burger = new Burger();
        this.drink = new Drink();
        this.sideItem = new SideItem();
    }

    public Meal(Burger burger, Drink drink, SideItem sideItem) {
        this.burger = burger;
        this.drink = drink;
        this.sideItem = sideItem;
    }

    public Burger getBurger() {
        return burger;
    }

    public Drink getDrink() {
        return drink;
    }

    public SideItem getSideItem() {
        return sideItem;
    }

    public void changeDrinkSize(Drink.SIZE size) {
        this.drink.setSize(size);
    }

    public String getItemsList() {
        return "-".repeat(50) + "\nBurger:" +
                "\n\tType: " + burger.getType().name() +
                "\n\tSize: " + burger.getSize().name() +
                "\n\tToppings: " + burger.getToppings().stream().map(Enum::name).collect(joining(", ", "[", "]")) +
                "\n\tPrice: " + "\t".repeat(5) + burger.getPriceInUsd() +
                "\n".repeat(2) +
                "Drink:" +
                "\n\tType: " + drink.getType() +
                "\n\tSize: " + drink.getSize() +
                "\n\tPrice: " + "\t".repeat(5) + drink.getPriceInUsd() +
                "\n".repeat(2) +
                "Side Item:" +
                "\n\tType: " + sideItem.getType().name() +
                "\n\tPrice: " + "\t".repeat(5) + sideItem.getPriceInUsd() +
                "\n".repeat(3) +
                "Total: " + (burger.getPriceInUsd() + drink.getPriceInUsd() + sideItem.getPriceInUsd()) +
                "\n" + "-".repeat(50) + "\n".repeat(3);
    }
}
