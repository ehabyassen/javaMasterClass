package com.example.collections.sortedCollections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StockList {

    private final Map<String, StockItem> items;

    public StockList() {
        items = new HashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            StockItem stockItem = items.get(item.getName());
            int quantityInStock = stockItem != null ? stockItem.getQuantityStock() : 0;
            item.adjustStock(quantityInStock);
            items.put(item.getName(), item);
            return item.getQuantityStock();
        }
        return 0;
    }

    public int sellStock(String itemName, int quantity) {
        StockItem stockItem = items.get(itemName);
        if (stockItem != null && stockItem.getQuantityStock() >= quantity) {
            stockItem.adjustStock(-quantity);
            return stockItem.getQuantityStock();
        }
        return 0;
    }

    public StockItem get(String name) {
        return items.get(name);
    }

    public Map<String, StockItem> getItems() {
        return Collections.unmodifiableMap(items);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> i : items.entrySet()) {
            StockItem stockItem = i.getValue();
            double itemValue = stockItem.getPrice() * stockItem.getQuantityStock();
            s = s + stockItem + ". There are " + stockItem.getQuantityStock() + " in stock. Value of items: ";
            s = s + String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }
        return s + "Total stock value: " + totalCost;
    }
}
