package academy.learnprogramming.encapsulation.challenge;

public class PrinterApp {

    public static void main(String[] args) {
        Printer printer = new Printer();
        System.out.println(printer.getTonerLevel());
        printer.addToner(20);
        System.out.println(printer.getTonerLevel());

        printer.setDuplex(true);
        printer.printPages(13);
        System.out.println(printer.getPagesPrinted());

        printer.setDuplex(false);
        printer.printPages(5);
        System.out.println(printer.getPagesPrinted());
    }
}
