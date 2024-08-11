package academy.learnprogramming.composition.challenge;

public class SmartKitchen {

    private Refrigator refrigator;
    private DishWasher dishWasher;
    private CoffeeMaker coffeeMaker;

    public SmartKitchen(Refrigator refrigator, DishWasher dishWasher, CoffeeMaker coffeeMaker) {
        this.refrigator = refrigator;
        this.dishWasher = dishWasher;
        this.coffeeMaker = coffeeMaker;
    }

    public CoffeeMaker getCoffeeMaker() {
        return coffeeMaker;
    }

    public void addWater() {
        coffeeMaker.setHasWorkTodo(true);
    }

    public void pourMilk() {
        refrigator.setHasWorkToDo(true);
    }

    public void loadDishWasher() {
        dishWasher.setHasWorkTodo(true);
    }

    public void doKitchenWork() {
        coffeeMaker.brewCoffee();
    }
}
