package academy.learnprogramming.composition.challenge;

public class DishWasher extends Appliance {

    private boolean hasWorkTodo;

    public DishWasher(String manufacturer) {
        super(manufacturer);
        this.hasWorkTodo = false;
    }

    public void setHasWorkTodo(boolean hasWorkTodo) {
        this.hasWorkTodo = hasWorkTodo;
    }

    public void cleanDishes() {
        if(hasWorkTodo) {
            System.out.println("Cleaning dishes.");
            hasWorkTodo = false;
        }
    }
}
