package com.learn.abstractClass.challenge;

public class MyLinkedList {

    private ListItem root;

    public void addItem(ListItem item) {
        if (root == null) {
            root = item;
        } else {
            ListItem tmp = root;
            while(tmp != null) {
                int cmp = tmp.compareTo(item);
                if (cmp == 0) {
                    System.out.println("Item [" + item.getValue() + "] already exists.");
                    break;
                } else if (cmp < 0) {
                    if (tmp.next() == null) {
                        tmp.setNext(item);
                        item.setPrevious(tmp);
                        break;
                    } else {
                        tmp = tmp.next();
                    }
                } else {
                    if (tmp.previous() != null) {
                        tmp.previous().setNext(item);
                        item.setPrevious(tmp.previous());
                        item.setNext(tmp);
                        tmp.setPrevious(item);
                        break;
                    } else {
                        item.setNext(this.root);
                        this.root.setPrevious(item);
                        this.root = item;
                        break;
                    }
                }
            }
        }
    }

    public void traverse() {
        ListItem tmp = root;
        while (tmp != null) {
            System.out.print(tmp.getValue() + " -> ");
            tmp = tmp.next();
        }
        System.out.println();
    }

    public void removeItem(ListItem item) {
        ListItem tmp = root;
        while (tmp != null) {
            if (tmp.compareTo(item) == 0) {
                if (tmp.compareTo(root) == 0) {
                    root = tmp.next();
                    if (tmp.next() != null) {
                        tmp.next().setPrevious(null);
                    }
                } else {
                    if (tmp.next() != null) {
                        tmp.next().setPrevious(tmp.previous());
                    }
                    tmp.previous().setNext(tmp.next());
                }
                break;
            } else {
                tmp = tmp.next();
            }
        }
    }
}
