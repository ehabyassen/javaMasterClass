package com.example.collections.map.baeldung.HashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Product {

    private String name;
    private String description;
    private List<String> tags;

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
        this.tags = new ArrayList<>();
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    public Product addTagsOfOtherProduct(Product product) {
        tags.addAll(product.getTags());
        return this;
    }

    //region getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getTags() {
        return Collections.unmodifiableList(tags);
    }
    //endregion
}
