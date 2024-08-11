package com.learn.abstractClass.challenge;

public abstract class ListItem {

    protected String value;
    protected ListItem previous;
    protected ListItem next;

    public ListItem(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public abstract ListItem next();
    public abstract ListItem previous();

    public abstract void setPrevious(ListItem previous);

    public abstract void setNext(ListItem next);

    public abstract int compareTo(ListItem item);
}
