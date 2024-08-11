package academy.learnprogramming.composition.challenge;

public class SmartKitchenApp {

    public static void main(String[] args) {
        CoffeeMaker coffeeMaker = new CoffeeMaker("Tefal");
        DishWasher dishWasher = new DishWasher("LG");
        Refrigator refrigator = new Refrigator("Toshiba");
        SmartKitchen smartKitchen = new SmartKitchen(refrigator, dishWasher, coffeeMaker);

        smartKitchen.addWater();
        smartKitchen.doKitchenWork();


    }
}
