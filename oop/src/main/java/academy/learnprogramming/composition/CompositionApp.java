package academy.learnprogramming.composition;

public class CompositionApp {

    public static void main(String[] args) {
        Monitor monitor = new Monitor("HP", "re322", 27, "2540 * 1440");
        Motherboard motherboard = new Motherboard("DELL", "123", 2, 2, "v2");
        ComputerCase computerCase = new ComputerCase("DELL", "wdklj43", "220");

        Computer computer = new Computer("IBM", "ij123", monitor, motherboard, computerCase);

        computer.draw(1, 2, "red");
        computer.loadProgram("Tetris");
        computer.pressPowerButton();
    }
}
