package com.example;

public class AccessModifiersApp {

    public static void main(String[] args) {
        PrivateClass a = new PrivateClass("A");
        PrivateClass.InnerClass b = a.new InnerClass();

        a.printOuterClassName();
        a.printInnerClassName();
        b.printName();
    }
}
