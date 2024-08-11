package academy.learnprogramming.composition;

public class Motherboard extends Product {

    private int ramSlots;
    private int cardSlots;
    private String bios;


    public Motherboard(String manufacturer, String model) {
        super(manufacturer, model);
    }

    public Motherboard(String manufacturer, String model, int ramSlots, int cardSlots, String bios) {
        super(manufacturer, model);
        this.ramSlots = ramSlots;
        this.cardSlots = cardSlots;
        this.bios = bios;
    }

    public void loadProgram(String programName) {
        System.out.println("Loading " + programName);
    }
}
