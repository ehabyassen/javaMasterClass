package academy.learnprogramming.composition.challenge;

public class Refrigator extends Appliance {

    private boolean hasWorkToDo;

    public Refrigator(String manufacturer) {
        super(manufacturer);
        this.hasWorkToDo = false;
    }

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public void orderFood() {
        if (hasWorkToDo) {
            System.out.println("Ordering food.");
            hasWorkToDo = false;
        }
    }
}
