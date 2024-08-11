package academy.learnprogramming.composition;

public class Computer extends Product {

    private Monitor monitor;
    private Motherboard motherboard;
    private ComputerCase computerCase;

    public Computer(String manufacturer, String model, Monitor monitor, Motherboard motherboard, ComputerCase computerCase) {
        super(manufacturer, model);
        this.monitor = monitor;
        this.motherboard = motherboard;
        this.computerCase = computerCase;
    }

    public void draw(int x, int y, String color) {
        monitor.drawPixel(x, y, color);
    }

    public void loadProgram(String program) {
        motherboard.loadProgram(program);
    }

    public void pressPowerButton() {
        computerCase.pressPowerButton();
    }
}
