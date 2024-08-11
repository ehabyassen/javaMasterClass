package academy.learnprogramming.composition;

public class Monitor extends Product {

    private int size;
    private String resolution;

    public Monitor(String manufacturer, String model, int size, String resolution) {
        super(manufacturer, model);
        this.size = size;
        this.resolution = resolution;
    }

    public void drawPixel(int x, int y, String color) {
        System.out.printf("Drawing pixel at %d, %d in color %s%n", x, y, color);
    }
}
