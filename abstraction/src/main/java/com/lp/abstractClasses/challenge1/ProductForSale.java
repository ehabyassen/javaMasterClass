package com.lp.abstractClasses.challenge1;

public abstract class ProductForSale {

    protected final String type;
    protected final double price;
    protected final String description;

    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public double getTotalSalesPrice(int quantity) {
        return price * quantity;
    }

    public void printPricedItem(int quantity) {
        System.out.printf("%2d quantity at $%8.2f each, %-15s %-35s %n",
                quantity, price, type, description);
    }

    public abstract void showDetails();
}
