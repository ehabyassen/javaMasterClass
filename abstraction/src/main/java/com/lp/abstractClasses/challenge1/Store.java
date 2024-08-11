package com.lp.abstractClasses.challenge1;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private final List<List<OrderItem>> orders;
    private static final List<ProductForSale> PRODUCTS = new ArrayList<>();

    public Store() {
        this.orders = new ArrayList<>();
    }

    public void newOrder() {
        orders.add(new ArrayList<>());
    }

    public void addItemToOrder(int index, OrderItem item) {
        orders.get(index).add(item);
    }

    public void printOrder(int index) {
        double total = 0;
        for (OrderItem item : orders.get(index)) {
            item.product().printPricedItem(item.quantity());
            total += item.product().getTotalSalesPrice(item.quantity());
        }
        System.out.printf(" Total: $%8.2f", total);
    }

    public static void listProducts() {
        PRODUCTS.forEach(ProductForSale::showDetails);
    }

    public static void main(String[] args) {
        PRODUCTS.add(new ArtObject("Oil Painting", 1350,
                "Impressionistic work by ABF painted in 2010"));
        PRODUCTS.add(new ArtObject("Sculpture", 2000,
                "Bronze work by JKF, produced in 1950"));
        PRODUCTS.add(new Furniture("Desk", 500, "Mahogany Desk"));
        PRODUCTS.add(new Furniture("Lamp", 200, "Tiffany Lamp with Hummingbirds"));
        listProducts();

        Store store = new Store();
        store.newOrder();
        store.addItemToOrder(0, new OrderItem(3, PRODUCTS.get(0)));
        store.addItemToOrder(0, new OrderItem(2, PRODUCTS.get(1)));
        System.out.println("Order 1:");
        store.printOrder(0);

        System.out.println();
        System.out.println("=".repeat(30));

        store.newOrder();
        store.addItemToOrder(1, new OrderItem(7, PRODUCTS.get(2)));
        store.addItemToOrder(1, new OrderItem(5, PRODUCTS.get(3)));
        System.out.println("Order 2:");
        store.printOrder(1);
    }
}
