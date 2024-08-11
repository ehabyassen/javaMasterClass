package com.learnprogramming;

import java.util.LinkedList;
import java.util.ListIterator;

public class Demo {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        addInOrder(list, "C");
        addInOrder(list, "B");
        addInOrder(list, "E");
        addInOrder(list, "B");
        addInOrder(list, "A");
        addInOrder(list, "D");

        printList(list);
    }

    private static void addInOrder(LinkedList<String> list, String item) {
        ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
            int comp = it.next().compareTo(item);
            if (comp == 0) {
                System.out.println("item already there");
                return;
            } else if (comp > 0) {
                it.previous();
                it.add(item);
                return;
            }
        }
        it.add(item);
    }

    private static void visit(LinkedList<String> list) {

    }

    private static void printList(LinkedList<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("-".repeat(30));
    }
}
