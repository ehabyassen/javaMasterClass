package com.example.collections.sortedCollections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket {

    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        list = new HashMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if (item != null && quantity > 0) {
            Integer inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public Map<StockItem, Integer> items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size() + " items\n";
        double total = 0.0;
        for (Map.Entry<StockItem, Integer> i : list.entrySet()) {
            s = s + i.getKey().getName() + ". " + i.getValue() + " purchased\n";
            total += i.getKey().getPrice() * i.getValue();
        }
        return s + "Total cost: " + total;
    }
}
