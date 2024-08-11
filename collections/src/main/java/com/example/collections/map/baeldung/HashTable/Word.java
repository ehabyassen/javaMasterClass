package com.example.collections.map.baeldung.HashTable;

public class Word {

    private String name;

    public Word(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return name.equals(word.getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
