package academy.learnprogramming.encapsulation.challenge;

public class Printer {

    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer() {
        this.tonerLevel = 100;
        this.pagesPrinted = 0;
        this.duplex = false;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public void setDuplex(boolean duplex) {
        this.duplex = duplex;
    }

    public void addToner(int tonerAmount) {
        tonerAmount = Math.max(tonerAmount, 0);
        if (tonerAmount + tonerLevel > 100) {
            tonerLevel = 100;
        }
    }

    public void printPages(int pages) {
        if (duplex) {
            System.out.println("Printing [" + pages + "] in duplex mode.");
            pagesPrinted += Math.ceil(pages / 2.0);
        } else {
            System.out.println("Printing [" + pages + "] in normal mode.");
            pagesPrinted += pages;
        }
    }
}
