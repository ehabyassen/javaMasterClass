package academy.learnprogramming.oopChallenge;

public class BurgerApp {

    public static void main(String[] args) {
        Meal defaultMeal = new Meal();
        System.out.println(defaultMeal.getItemsList());

        Burger burger1 = new Burger(Burger.TYPE.Chilli, Burger.SIZE.xl);
        burger1.addTopping(Burger.TOPPING.garlic);
        burger1.addTopping(Burger.TOPPING.mustard);
        burger1.addTopping(Burger.TOPPING.catchup);
        burger1.addTopping(Burger.TOPPING.catchup);
        SideItem sideItem1 = new SideItem(SideItem.TYPE.OnionRings);
        Drink drink1 = new Drink("Fanta", Drink.SIZE.l);
        Meal meal1 = new Meal(burger1, drink1, sideItem1);
        System.out.println(meal1.getItemsList());
        meal1.changeDrinkSize(Drink.SIZE.m);
        System.out.println(meal1.getItemsList());

        Burger deluxeBurger = new Burger(Burger.TYPE.Deluxe, Burger.SIZE.xxl);
        deluxeBurger.addTopping(Burger.TOPPING.garlic);
        deluxeBurger.addTopping(Burger.TOPPING.mustard);
        deluxeBurger.addTopping(Burger.TOPPING.mustard);
        deluxeBurger.addTopping(Burger.TOPPING.catchup);
        deluxeBurger.addTopping(Burger.TOPPING.catchup);
        deluxeBurger.addTopping(Burger.TOPPING.catchup);
        SideItem deluxeSide = new SideItem(SideItem.TYPE.IceCream);
        Drink deluxeDrink = new Drink("7UP", Drink.SIZE.m);
        Meal deluxeMeal = new Meal(deluxeBurger, deluxeDrink, deluxeSide);
        System.out.println(deluxeMeal.getItemsList());
        deluxeMeal.changeDrinkSize(Drink.SIZE.s);
        System.out.println(deluxeMeal.getItemsList());
    }
}
