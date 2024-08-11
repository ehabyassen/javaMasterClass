package com.example.collections.map.baeldung.HashMap;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        Map<String, Product> productsByName = new HashMap<>();

        Product eBike = new Product("E-Bike", "A bike with a battery");
        Product roadBike = new Product("Road bike", "A bike for competition");
        productsByName.put(eBike.getName(), eBike);
        productsByName.put(roadBike.getName(), roadBike);

        Product nextPurchase = productsByName.get("E-Bike");
        System.out.println(nextPurchase.getDescription());

        System.out.println(productsByName.get("Car"));

        Product newEBike = new Product("E-Bike", "A bike with a better battery");
        productsByName.put(newEBike.getName(), newEBike);
        System.out.println(productsByName.get("E-Bike").getDescription());

        Product choco = new Product("Chocolate", "At least buy choco");
        productsByName.put(null, choco);
        productsByName.put(choco.getName(), choco);
        System.out.println(productsByName.get(null).getDescription());
        System.out.println(productsByName.get(choco.getName()).getDescription());

        productsByName.forEach((key, value) -> System.out.println(key + "." + value.getDescription()));

        System.out.println("-".repeat(20));
        System.out.println(productsByName.get("E-Bike").getTags());
        Product eBike2 = new Product("E-Bike", "A bike with a battery - v2");
        eBike2.addTag("sport");
        productsByName.merge("E-Bike", eBike2, Product::addTagsOfOtherProduct);
        System.out.println(productsByName.get("E-Bike").getTags());
        System.out.println(productsByName.get("E-Bike").getDescription());

        System.out.println("-".repeat(20));


        System.out.println("-".repeat(20));
    }
}
