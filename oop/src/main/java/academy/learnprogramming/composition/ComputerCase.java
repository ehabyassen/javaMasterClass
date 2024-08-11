package academy.learnprogramming.composition;

public class ComputerCase extends Product {

    private String powerSupply;

    public ComputerCase(String manufacturer, String model) {
        super(manufacturer, model);
    }

    public ComputerCase(String manufacturer, String model, String powerSupply) {
        super(manufacturer, model);
        this.powerSupply = powerSupply;
    }

    public void pressPowerButton() {
        System.out.println("Power button pressed.");
    }
}
