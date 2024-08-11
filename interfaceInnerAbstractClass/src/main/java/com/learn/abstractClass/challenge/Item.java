package com.learn.abstractClass.challenge;

public class Item extends ListItem {

    public Item(String value) {
        super(value);
    }

    @Override
    public ListItem next() {
        return this.next;
    }

    @Override
    public ListItem previous() {
        return this.previous;
    }

    @Override
    public void setPrevious(ListItem previous) {
        this.previous = previous;
    }

    @Override
    public void setNext(ListItem next) {
        this.next = next;
    }

    @Override
    public int compareTo(ListItem item) {
        return this.getValue().compareTo(item.getValue());
    }
}
