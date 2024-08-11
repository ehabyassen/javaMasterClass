package academy.learnprogramming.composition.challenge;

public class CoffeeMaker extends Appliance {

    private boolean hasWorkTodo;

    public CoffeeMaker(String manufacturer) {
        super(manufacturer);
        this.hasWorkTodo = false;
    }

    public void setHasWorkTodo(boolean hasWorkTodo) {
        this.hasWorkTodo = hasWorkTodo;
    }

    public void brewCoffee() {
        if (hasWorkTodo) {
            System.out.println("Brewing coffee.");
            hasWorkTodo = false;
        }
    }
}
