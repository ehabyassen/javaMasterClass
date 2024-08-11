package academy.learnprogramming.inheritance;

public class Shape {

    private int x;
    private int y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getArea() {return 0;}

    public int getArea(int x, int y) {
        return x * y;
    }

    public static void print() {}
}

class Rectange extends Shape {

    private int height;
    private int width;

    public Rectange(int x, int y) {
        this(x, y, 0 ,0);
    }

    public Rectange(int x, int y, int height, int width) {
        super(x, y);
        this.height = height;
        this.width = width;
    }

    @Override
    public int getArea() {
        return 1;
    }

    @Override
    public int getArea(int x, int y) {
        return x / y;
    }

}