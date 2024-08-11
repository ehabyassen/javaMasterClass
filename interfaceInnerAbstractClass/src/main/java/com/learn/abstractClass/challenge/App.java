package com.learn.abstractClass.challenge;

public class App {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.addItem(new Item("D"));
        list.addItem(new Item("A"));
        list.addItem(new Item("C"));
        list.addItem(new Item("B"));
        list.addItem(new Item("A"));
        list.addItem(new Item("C"));
        list.traverse();
        list.removeItem(new Item("A"));
        list.traverse();
        list.removeItem(new Item("D"));
        list.traverse();


    }
}
